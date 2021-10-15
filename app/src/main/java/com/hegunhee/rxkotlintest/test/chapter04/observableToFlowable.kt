package com.hegunhee.rxkotlintest.test.chapter04

import io.reactivex.BackpressureStrategy
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

fun main(args: Array<String>) {
    val source = Observable.range(1, 1000)
    source.toFlowable(BackpressureStrategy.BUFFER)
        .map { MyItem7(it) }
        .observeOn(Schedulers.io())
        .subscribe {
            print("Rec. $it;\t")
            runBlocking { delay(1000) }
        }
    runBlocking { delay(10000) }

}

data class MyItem7(val id: Int) {
    init {
        print("MyItem init $id")
    }
}