package com.hegunhee.rxkotlintest.test.chapter03

import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.disposables.Disposable

fun main(args: Array<String>) {
    val observer: Observer<Any> = object : Observer<Any> {
        override fun onComplete() {
            println("All Complete")
        }

        override fun onSubscribe(d: Disposable) {
            println("Subscribed to $d")
        }

        override fun onNext(t: Any) {
            println("Next $t")
        }

        override fun onError(e: Throwable) {
            println("Error Occured ${e.message}")
        }
    }

    Observable.just("A String").subscribe(observer)
    Observable.just(54).subscribe(observer)
    Observable.just(listOf("String 1", "String 2", "String 3", "String 4")).subscribe(observer)
    Observable.just(
        mapOf(
            Pair("Key 1", "Value 1"),
            Pair("Key 2", "Value 2"),
            Pair("Key 3", "Value 3")
        )
    ).subscribe(observer)
    Observable.just(arrayListOf(1,2,3,4,5,6)).subscribe(observer)
    Observable.just("String 1","String 2","String 3").subscribe(observer)
}