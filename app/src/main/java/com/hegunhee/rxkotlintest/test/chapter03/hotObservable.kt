package com.hegunhee.rxkotlintest.test.chapter03

import android.annotation.SuppressLint
import io.reactivex.Observable
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import java.util.concurrent.TimeUnit

@SuppressLint("CheckResult")
fun main(args :Array<String>){
    val connectableObservable = Observable.interval(100,TimeUnit.MILLISECONDS)
        .publish()
    connectableObservable.subscribe({println("Subscription 1: $it")})
    connectableObservable.subscribe({println("Subscription 2: $it")})
    connectableObservable.connect()
    runBlocking { delay(500) }

    connectableObservable.subscribe({println("Subscription 3 : $it")})
    runBlocking { delay(500) }
}