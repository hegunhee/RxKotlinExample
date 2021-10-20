package com.hegunhee.rxkotlintest.test.chapter06

import io.reactivex.Observable
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import java.util.concurrent.TimeUnit

fun main(args : Array<String>){
    val observable1 = Observable.range(1,10).map { "Received 1 $it" }
    val observable2 = Observable.range(5,10).map { "Received 2 $it" }

    Observable.amb(listOf(observable1,observable2))
        .subscribe{
            println("Received $it")
        }

}