package com.hegunhee.rxkotlintest.test.chapter04

import io.reactivex.Flowable
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import org.reactivestreams.Subscriber
import org.reactivestreams.Subscription

fun main(args :Array<String>){
    Flowable.range(1,15)
        .map { MyItem6(it) }
        .observeOn(Schedulers.io())
        .subscribe(object : Subscriber<MyItem6>{
            lateinit var subscription : Subscription
            override fun onSubscribe(subscription: Subscription) {
                this.subscription = subscription
                subscription.request(5)
            }

            override fun onNext(t: MyItem6?) {
                runBlocking { delay(50) }
                println("Subscriber received " + t!!)
                if(t.id == 5){
                    println("Requesting two more")
                    subscription.request(2)
                }
            }

            override fun onError(t: Throwable) {
                t.printStackTrace()
            }

            override fun onComplete() {
                println("Done!")
            }

        })
    runBlocking { delay(10000) }
}
data class MyItem6(val id : Int){
    init {
        println("MyItem Created $id")
    }
}