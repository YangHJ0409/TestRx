package com.zz.yang.test.rx.algorithm

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.zz.yang.test.rx.databinding.RowItemAlgorithmBinding

class AlgorithmAdapter: RecyclerView.Adapter<AlgorithmAdapter.AlgorithmViewHolder>() {

    private val arrayModel = mutableListOf<AlgorithmModel>()

    inner class AlgorithmViewHolder(private val binding: RowItemAlgorithmBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(model: AlgorithmModel) {
            binding.modelAlgorithm = model
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlgorithmViewHolder {
        return AlgorithmViewHolder(RowItemAlgorithmBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun getItemCount(): Int {
        return arrayModel.size
    }

    override fun onBindViewHolder(holder: AlgorithmViewHolder, position: Int) {
        holder.bind(arrayModel[position])
    }
}