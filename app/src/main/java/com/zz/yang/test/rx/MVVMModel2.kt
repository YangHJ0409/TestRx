package com.zz.yang.test.rx

class MVVMModel2(var name: String, var number: Int) {

//    var number: Int = 0
    var numberStr = "0"
    fun addValue() {
        number++
        numberStr = number.toString()
        println("Model::addValue::$number, $numberStr")
    }

//    fun toString() {
//
//    }

    fun update(name: String, value: Int) {
        this.name = name
        this.number = value
        println("Model::name::$name, $number")
    }

    fun reset() {
        this.name = "이름없음"
        this.number = 0
    }

    fun print() {
        println("Model::name = $name, number = $number")
    }
}