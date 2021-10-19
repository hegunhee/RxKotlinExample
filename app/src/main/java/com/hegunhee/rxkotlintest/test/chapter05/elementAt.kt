package com.hegunhee.rxkotlintest.test.chapter05

import io.reactivex.rxkotlin.toObservable

fun main(args  : Array<String>){
    val observable = listOf(10,1,2,5,8,6,9)
        .toObservable()
    observable.elementAt(5)
        .subscribe{println("Received $it")}

    observable.elementAt(50)
        .subscribe{println("Received $it")}
}