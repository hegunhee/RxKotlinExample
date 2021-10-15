package com.hegunhee.rxkotlintest.test.chapter04

import io.reactivex.Flowable

fun main(args: Array<String>) {
    val flowable = Flowable.range(1, 111)
    flowable.window(10)
        .subscribe { flo ->
            flo.subscribe {
                print("$it, ")
            }
            println()
        }
}