package com.hegunhee.rxkotlintest.test.chapter06

import io.reactivex.Observable
import io.reactivex.rxkotlin.toObservable

fun main(args : Array<String>){
    val observable1 = listOf("Kotlin","Scala","Groovy").toObservable()
    val observable2 = listOf("Python","Java","C++","C").toObservable()

    Observable.merge(observable1,observable2)
        .subscribe{
            println("Received $it")
        }
}