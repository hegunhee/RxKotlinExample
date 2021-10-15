package com.hegunhee.rxkotlintest.test.chapter04

import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

fun main(args: Array<String>) {
    Observable.range(1, 1000)
        .map { MyItem3(it) }
        .observeOn(Schedulers.computation())
        .subscribe({
            print("Received $it;\t")
            runBlocking { delay(50) }
        }, { it.printStackTrace() })
    runBlocking { delay(6000) }
}

data class MyItem3(val id: Int) {
    init {
        print("MyItem Created $id;\t")
    }
}