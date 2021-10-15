package com.hegunhee.rxkotlintest.test.chapter04

import io.reactivex.BackpressureStrategy
import io.reactivex.Flowable
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import org.reactivestreams.Subscriber
import org.reactivestreams.Subscription

fun main(args: Array<String>) {
    val subscriber: Subscriber<Int> = object : Subscriber<Int> {
        override fun onComplete() {
            println("All Completed")
        }

        override fun onNext(t: Int) {
            println("Next $t")
        }

        override fun onError(t: Throwable?) {
            println("Error Occured ${t?.printStackTrace()}")
        }

        override fun onSubscribe(s: Subscription?) {
            println("New Subscription ")
            s?.request(10)
        }
    }
    val flowable: Flowable<Int> = Flowable.create<Int>({
        for (i in 1..10) {
            it.onNext(i)
        }
        it.onComplete()
    }, BackpressureStrategy.BUFFER)

    flowable.observeOn(Schedulers.io())
        .subscribe(subscriber)

    runBlocking { delay(10000) }
}