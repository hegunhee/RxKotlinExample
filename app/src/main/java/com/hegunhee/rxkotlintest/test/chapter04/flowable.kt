package com.hegunhee.rxkotlintest.test.chapter04

import io.reactivex.Flowable
import io.reactivex.Scheduler
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

fun main(args : Array<String>){
    Flowable.range(1,1000)
        .map { MyItem4(it) }
        .observeOn(Schedulers.io())
        .subscribe({
            println("Received $it")
            runBlocking { delay(50) }
        },{it.printStackTrace()})
    runBlocking { delay(60000) }
}
data class MyItem4(val id:Int){
    init {
        println("MyItem Created $id")
    }
}