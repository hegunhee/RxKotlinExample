package com.hegunhee.rxkotlintest.test.chapter04

import io.reactivex.processors.PublishProcessor
import io.reactivex.rxkotlin.toFlowable
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

fun main(args : Array<String>){
    val flowable = listOf("String 1","String 2","String 3","String 4","String 5").toFlowable()

    val processor = PublishProcessor.create<String>()

    processor.
            subscribe({
                println("Subscription 1: $it")
                runBlocking { delay(1000) }
                println("Subscription 1 delay")
            })
    processor.subscribe({println("Subscription 2 $it")})
    flowable.subscribe(processor)
}