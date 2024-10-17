package com.zz.yang.test.rx

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MVVMViewModel2: ViewModel() {
//    private val _model = MutableLiveData(MVVMModel2("양혁진", 1))
//    val model: LiveData<MVVMModel2> = _model
    private val model = MutableLiveData(MVVMModel2("양혁진", -1))

//    private val _model = MutableLiveData<Lifecycle.Event<MVVMModel2>>()
//    val model: LiveData<Lifecycle.Event<MVVMModel2>> = _showToastEvent


    private val _testModel33 = MutableLiveData<TestModel33>(TestModel33())
//    val priceModel = _testModel33
    private val priceModel = TestModel33()

//    fun add() {
//        _model.value?.addValue()
//        _model.postValue(_model.value)
//        println("ViewModel::add()")
//    }

    fun updateNext() {
        val temp = (model.value?.number ?: 0) + 1
        model.value?.update("한준영", temp)
        model.value = model.value
    }

    fun updateLast() {
        CoroutineScope(Dispatchers.Main).launch {
            val temp = (model.value?.number ?: 0) + 100
//        _model.value?.update("김남이", temp)
//        _model.postValue(_model.value)
            model.value?.update("김남이", temp)
            model.postValue(model.value)
        }
    }

    fun getName(): String {
        return model.value?.name ?: "없음"
    }

    fun getNumber(): String {
        return model.value?.number.toString() ?: "-1000"
    }

    fun addPriceBuilding() {
        priceModel.addBuilding()
//        _testModel33.value?.addBuilding()
        _testModel33.value = priceModel
        println(priceModel.sumPrice)
    }

    fun priceReset() {
        priceModel.reset()
        _testModel33.postValue(priceModel)
    }

    fun getPriceSum(): String {
        return priceModel.sumPrice.toString() ?: "-1000"
    }
}