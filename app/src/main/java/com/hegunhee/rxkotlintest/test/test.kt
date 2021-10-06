package com.hegunhee.rxkotlintest.test

import android.util.Log
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.rxkotlin.toObservable

fun main(args: Array<String>) {
    val list = listOf<String>("hello", "ho").toObservable()
    list.subscribeBy(
        onNext = { println(it) },
        onComplete = { println("end")},
        onError = { println("Error")}
    )
}