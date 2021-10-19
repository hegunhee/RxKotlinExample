package com.hegunhee.rxkotlintest.test.chapter05

import io.reactivex.Observable

fun main(args : Array<String>){
    Observable.range(0,10)
        .filter { it>15 }
        .switchIfEmpty(Observable.range(11,10))
        .subscribe({
            println("Received $it")
        })
}