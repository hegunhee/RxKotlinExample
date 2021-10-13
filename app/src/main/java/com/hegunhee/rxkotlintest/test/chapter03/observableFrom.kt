package com.hegunhee.rxkotlintest.test.chapter03

import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import java.util.concurrent.Callable
import java.util.concurrent.Future
import java.util.concurrent.TimeUnit

fun main(args :Array<String>){
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

    val list = listOf("String 1","String 2","String 3","String 4")
    val observableFromIterable : Observable<String> = Observable.fromIterable(list)
    observableFromIterable.subscribe(observer)

    val callable = object : Callable<String>{
        override fun call(): String {
            return "From Callable"
        }
    }
    val observableFromCallable:Observable<String> = Observable.fromCallable(callable)
    observableFromCallable.subscribe(observer)

    val future : Future<String> = object : Future<String>{
        override fun cancel(p0: Boolean): Boolean {
            return false
        }

        override fun isCancelled(): Boolean {
            return false
        }

        override fun isDone(): Boolean {
            return true
        }

        override fun get(): String {
            return "Hello From Future"
        }

        override fun get(p0: Long, p1: TimeUnit?): String {
            return "Hello From Future"
        }

    }
    val observableFromFuture:Observable<String> = Observable.fromFuture(future)
    observableFromFuture.subscribe(observer)
}