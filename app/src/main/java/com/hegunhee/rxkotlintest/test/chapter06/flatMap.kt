package com.hegunhee.rxkotlintest.test.chapter06

import io.reactivex.Observable
import java.util.*
import java.util.concurrent.TimeUnit

fun main(args : Array<String>){
    Observable.range(1,10)
        .flatMap {
            val randDelay = Random().nextInt(10)
            return@flatMap Observable.just(it)
                .delay(randDelay.toLong(),TimeUnit.MILLISECONDS)
        }
        .blockingSubscribe{
            println("Received $it")
        }
}