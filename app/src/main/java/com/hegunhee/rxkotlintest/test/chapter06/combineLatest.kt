package com.hegunhee.rxkotlintest.test.chapter06

import io.reactivex.Observable
import io.reactivex.functions.BiFunction
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import java.util.concurrent.TimeUnit

fun main(args : Array<String>){
    val observable1 = Observable.interval(100,TimeUnit.MILLISECONDS)
    val observable2 = Observable.interval(250,TimeUnit.MILLISECONDS)
    Observable.zip(observable1,observable2, BiFunction{
        t1:Long,t2:Long -> "t1: $t1 t2: $t2"
    }).subscribe{
        println("Received $it")
    }

    runBlocking { delay(1100) }
}