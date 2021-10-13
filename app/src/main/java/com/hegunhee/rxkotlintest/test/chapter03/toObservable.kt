package com.hegunhee.rxkotlintest.test.chapter03

import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import io.reactivex.rxkotlin.toObservable

fun main(args :Array<String>) {
    val observer: Observer<String> = object : Observer<String> {
        override fun onComplete() {
            println("All Complete")
        }

        override fun onSubscribe(d: Disposable) {
            println("Subscribed to $d")
        }

        override fun onNext(t: String) {
            println("Next $t")
        }

        override fun onError(e: Throwable) {
            println("Error Occured ${e.message}")
        }
    }

    val list : List<String> = listOf("String 1", "String 2","String 3","String 4")

    val observable : Observable<String> = list.toObservable()

    observable.subscribe(observer)
}