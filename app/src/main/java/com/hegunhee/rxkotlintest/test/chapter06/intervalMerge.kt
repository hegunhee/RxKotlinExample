package com.hegunhee.rxkotlintest.test.chapter06

import io.reactivex.Observable
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import java.util.concurrent.TimeUnit

fun main(args : Array<String>){
    val observable1 = Observable.interval(500,TimeUnit.MILLISECONDS).map { "Observable 1 $it" }
    val observable2 = Observable.interval(100,TimeUnit.MILLISECONDS).map { "Observable 2 $it" }

    Observable
        .merge(observable1,observable2)
        .subscribe{
            println("Received $it")
        }
    runBlocking { delay(1500) }
}