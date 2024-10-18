package com.zz.yang.test.rx.struct

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import com.zz.yang.test.rx.R
import com.zz.yang.test.rx.databinding.ActivityStructBinding
import org.w3c.dom.Text

class StructActivity : AppCompatActivity() {
    private lateinit var binding: ActivityStructBinding
    private val viewModel: StructViewModel by viewModels()

    lateinit var textViewArrayList: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = DataBindingUtil.setContentView(this, R.layout.activity_struct)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this

        textViewArrayList = findViewById<TextView>(R.id.array_list)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        viewModel.model.observe(this) {
            println("observe!!::${viewModel.getHeap()}")
            textViewArrayList.text = viewModel.getHeap()
        }
    }
}