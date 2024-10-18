package com.zz.yang.test.rx.struct

import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class StructViewModel: ViewModel() {
    private val _model = MutableLiveData<StructModel>()
    val model:LiveData<StructModel> get() = _model

    var addOrDel = false

    init {
        val item = StructModel()
        _model.value = item
    }

    fun changeHeapMode() {
        model.value?.MIN_OR_MAX = !(model.value?.MIN_OR_MAX ?: false)
    }

    fun changeAddMode() {
        this.addOrDel = !this.addOrDel
    }

    fun addHeap(value: Int) {
        if (this.addOrDel) {
            model.value?.addHeap(value)
        } else {
            model.value?.delHeap(value)
        }
        _model.value = model.value
    }

    fun checkHeap() {

    }

    fun getHeap(): String {

        val result = _model.value?.getHeapToString() ?: ""
        return result
    }

}