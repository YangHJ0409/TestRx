package com.zz.yang.test.rx.algorithm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class AlgorithmViewModel: ViewModel() {
    private var _listAlgorithmModel = MutableLiveData<List<AlgorithmModel>>()
    val listAlgorithmModel: LiveData<List<AlgorithmModel>> get() = _listAlgorithmModel

    private var items = mutableListOf<AlgorithmModel>()
    init {
        items.add(AlgorithmModel(0, "테스트1"))
        items.add(AlgorithmModel(0, "테스트2"))
        _listAlgorithmModel.postValue(items)
    }
}