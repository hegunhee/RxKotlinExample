package com.hegunhee.rxkotlintest.test.chapter07

import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

fun main(args  :Array<String>){
    Observable.range(1,10)
        .subscribeOn(Schedulers.computation())
        .subscribe{
            runBlocking { delay(200) }
            println("Observable1 Item Received $it")
        }

    Observable.range(21,10)
        .subscribeOn(Schedulers.computation())
        .subscribe{
            runBlocking { delay(100) }
            println("Observable2 Item Received $it")
        }

    runBlocking { delay(2100) }
}