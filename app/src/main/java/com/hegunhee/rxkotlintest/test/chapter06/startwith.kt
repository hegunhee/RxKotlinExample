package com.hegunhee.rxkotlintest.test.chapter06

import io.reactivex.Observable

fun main(args : Array<String>){
    println("StartWith Iterator")
    Observable.range(5,10)
        .startWith(listOf(1,2,3,4))
        .subscribe{
            println("Received $it")
        }

    println("startWith anotrher source Producer")
    Observable.range(5,10)
        .startWith(Observable.just(1,2,3,4))
        .subscribe{
            println("Received $it")
        }
}