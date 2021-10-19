package com.hegunhee.rxkotlintest.test.chapter05

import io.reactivex.Observable
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import java.util.concurrent.TimeUnit

fun main(args : Array<String>){
    createObservable()
        .debounce (200,TimeUnit.MILLISECONDS)
        .subscribe{
            println(it)
        }

}

inline fun createObservable():Observable<String> =
    Observable.create<String>{
        it.onNext("R")
        runBlocking { delay(100) }
        it.onNext("Re")
        it.onNext("Reac")
        runBlocking { delay(130) }
        it.onNext("Reactiv")
        runBlocking { delay(140) }
        it.onNext("Reactive")
        runBlocking { delay(250) }
        it.onNext("Reactive P")
        runBlocking { delay(130) }
        it.onNext("Reactive Pro")
        runBlocking { delay(100) }
        it.onNext("Reactive Programing")
        runBlocking { delay(300) }
        it.onNext("Reactive Programing in")
        runBlocking { delay(100) }
        it.onNext("Reactive Programing in Kotlin")
        runBlocking { delay(250) }
        it.onComplete()
    }