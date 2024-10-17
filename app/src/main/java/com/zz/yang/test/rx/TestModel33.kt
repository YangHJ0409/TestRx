package com.zz.yang.test.rx

class TestModel33() {
    val price = 1000
    var sumPrice = 0
//    var sumPriceStr = sumPrice.toString()

    fun addBuilding() {
        sumPrice += price
    }

    fun reset() {
        sumPrice = 0
    }
}