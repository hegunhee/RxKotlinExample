package com.hegunhee.rxkotlintest.test.chapter04

import io.reactivex.BackpressureStrategy
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

fun main(args : Array<String>){
    val source = Observable.range(1,1000)
    source.toFlowable(BackpressureStrategy.MISSING)
        .onBackpressureLatest()
        .map { MyItem13(it) }
        .observeOn(Schedulers.io())
        .subscribe{
            print("-> $it;\t")
            runBlocking { delay(1000) }
        }
    runBlocking { delay(700000) }
}