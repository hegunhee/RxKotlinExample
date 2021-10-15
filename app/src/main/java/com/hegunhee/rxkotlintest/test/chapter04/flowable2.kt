package com.hegunhee.rxkotlintest.test.chapter04

import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.disposables.Disposable

fun main(args : Array<String>){
    val observer : Observer<Int> = object : Observer<Int>{
        override fun onComplete() {
            println("All Completed")
        }

        override fun onNext(t: Int) {
            println("Next $t")
        }

        override fun onError(e: Throwable) {
            println("Error Occured ${e.printStackTrace()}")
        }

        override fun onSubscribe(d: Disposable) {
            println("New Subscription")
        }
    }
    val observable : Observable<Int> = Observable.create<Int> {
        for(i in 1..10){
            it.onNext(i)
        }
        it.onComplete()
    }
    observable.subscribe(observer)
}