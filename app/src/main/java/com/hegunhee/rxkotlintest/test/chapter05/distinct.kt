package com.hegunhee.rxkotlintest.test.chapter05

import io.reactivex.rxkotlin.toObservable

fun main(args : Array<String>){
    listOf(1,2,2,3,4,5,5,5,6,7,8,9,3,10)
        .toObservable()
        .distinct()
        .subscribe{println("Received $it")}
}