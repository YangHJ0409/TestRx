package com.zz.yang.test.rx

import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.zz.yang.test.rx.databinding.ActivityMvvmactivity2Binding


class MVVMActivity2 : AppCompatActivity() {

    private lateinit var binding: ActivityMvvmactivity2Binding
    private lateinit var viewModel: MVVMViewModel2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
//        binding = ActivityMvvmactivity2Binding.bind(layoutInflater.)
//        binding = ActivityMvvmactivity2Binding.inflate(layoutInflater)
//        setContentView(binding.root)

        viewModel = ViewModelProvider(this)[MVVMViewModel2::class.java]//viewModel
        binding = DataBindingUtil.setContentView(this, R.layout.activity_mvvmactivity2)
        binding.muViewModel = viewModel
        binding.lifecycleOwner = this


//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets
//        }

//        val btn01 = findViewById<Button>(R.id.btn01)
//        binding?.btn01?.text = "987"

//        viewModel.model.observe(binding.lifecycleOwner!!) { it ->
//            println("viewModel.model.observe()::${it.name}, ${it.number}")
////            binding.btn01.text = it.name
////            binding.text01.text = it.numberStr
//        }
    }
}