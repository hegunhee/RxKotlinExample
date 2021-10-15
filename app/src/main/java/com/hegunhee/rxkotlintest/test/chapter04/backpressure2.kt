package com.hegunhee.rxkotlintest.test.chapter04

import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

fun main(args: Array<String>) {
    val observable = Observable.just(1, 2, 3, 4, 5, 6, 7, 8, 9)
    observable
        .map { MyItem(it) }
        .observeOn(Schedulers.computation())
        .subscribe({
            println("Received $it")
            runBlocking { delay(200) }
        })
    runBlocking { delay(2000) }
}

data class MyItem(val id: Int) {
    init {
        println("MyItem Created $id")
    }
}