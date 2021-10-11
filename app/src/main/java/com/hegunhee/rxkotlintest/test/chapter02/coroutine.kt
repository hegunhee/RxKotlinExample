package com.hegunhee.rxkotlintest.test.chapter02


import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import java.util.concurrent.TimeUnit
import kotlin.system.measureTimeMillis

suspend fun longRunningTsk() :Long {
    val time = measureTimeMillis {
        println("please wait")
        delay(2000)
        println("Delay Over")
    }
    return time
}
fun main(args: Array<String>){
    runBlocking {
        val exeTime = longRunningTsk()
        println("Execution Time is $exeTime")
    }
}
