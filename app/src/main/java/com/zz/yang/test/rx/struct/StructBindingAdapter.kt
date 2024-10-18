package com.zz.yang.test.rx.struct

import android.view.View
import android.widget.TextView
import androidx.databinding.BindingAdapter

object StructBindingAdapter {

    @BindingAdapter("bind:writeArray")
    @JvmStatic
    fun writeArray(textView: TextView, arrayIntArray: ArrayList<Int>) {
//        println("writeArray::${arrayIntArray.toString()}")
        println("writeArray::")
    }

//    @BindingAdapter("bind:switching")
//    @JvmStatic
//    fun switching(textView: TextView, arrayIntArray: ArrayList<Int>) {
////        println("writeArray::${arrayIntArray.toString()}")
//        println("writeArray::")
//    }
}