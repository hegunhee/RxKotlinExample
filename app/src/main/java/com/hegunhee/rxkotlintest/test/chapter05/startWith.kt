package com.hegunhee.rxkotlintest.test.chapter05

import io.reactivex.Observable
import io.reactivex.rxkotlin.toObservable

fun main(args : Array<String>){
    Observable.range(0,10)
        .startWith(-1)
        .subscribe({
            println("Received $it")
        })
    listOf("C","C++","Java","Kotlin","Scala","Groovy")
        .toObservable()
        .startWith("Programming Languages")
        .subscribe({
            println("Received $it")
        })
}