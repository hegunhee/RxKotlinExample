package com.hegunhee.rxkotlintest.test.chapter07

import io.reactivex.rxkotlin.toObservable

fun main(args : Array<String>){
    listOf("1","2","3","4","5","6","7","8","9","10")
        .toObservable()
        .map {
            item ->
            println("Mapping $item ${Thread.currentThread().name}")
            return@map item.toInt()
        }
        .subscribe{
            item -> println("Received $item" +
                "${Thread.currentThread().name}")
        }
}