package com.hegunhee.rxkotlintest.test.chapter05

import io.reactivex.Observable

fun main(args : Array<String>){
    val observable = Observable.range(1,10)
    observable
        .ignoreElements()
        .subscribe{println("Completed")}
}