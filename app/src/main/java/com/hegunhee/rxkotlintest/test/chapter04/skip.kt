package com.hegunhee.rxkotlintest.test.chapter04

import io.reactivex.Flowable

fun main(args : Array<String>){
    val flowable = Flowable.range(1,111)
    flowable.buffer(10,15)
        .subscribe{println("Subscription 1 $it")}
    flowable.buffer(15,7)
        .subscribe { println("Subscription 2 $it") }
}