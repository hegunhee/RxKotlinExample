package com.hegunhee.rxkotlintest.test.chapter04

import io.reactivex.Flowable
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import java.util.concurrent.TimeUnit

fun main(args : Array<String>){
    val flowable = Flowable.interval(100,TimeUnit.MILLISECONDS)
    flowable.buffer(1,TimeUnit.SECONDS)
        .subscribe{println(it)}
    runBlocking { delay(5000) }
}