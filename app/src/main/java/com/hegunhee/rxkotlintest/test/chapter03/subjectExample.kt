package com.hegunhee.rxkotlintest.test.chapter03

import io.reactivex.Observable
import io.reactivex.rxkotlin.Observables
import io.reactivex.subjects.PublishSubject
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import java.util.concurrent.TimeUnit

fun main(args: Array<String>) {
    val observable = Observable.interval(100, TimeUnit.MILLISECONDS)
    val subject = PublishSubject.create<Long>()
    observable.subscribe(subject)
    subject.subscribe({
        println("Subscription 1 Received $it")
    })
    runBlocking { delay(1100) }
    subject.subscribe({
        println("Subscription 2 Received $it")
    })
    runBlocking { delay(1100) }

    observable.subscribe({
        println("Cold Observable Received $it")
    }, {
        println("Error ${it.message}")
    }, {
        println("onCompleted")
    })

    runBlocking { delay(1100) }
}