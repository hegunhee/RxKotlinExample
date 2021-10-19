package com.hegunhee.rxkotlintest.test.chapter05

import io.reactivex.Observable

fun main(args : Array<String>){
    Observable.range(1,20)
        .filter {
            it%2 ==0
        }
        .subscribe{
            println("Received $it")
        }
}