package com.hegunhee.rxkotlintest.test.functionalKt

import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import java.util.concurrent.Callable
import java.util.concurrent.Future
import java.util.concurrent.TimeUnit

fun main(args : Array<String>){
    val observer: Observer<String> = object : Observer<String> {
        override fun onComplete() {
            println("완료됨")
        }

        override fun onSubscribe(d: Disposable) {
            println("구독")
        }

        override fun onNext(t: String) {
            println("받음 -> $t")
        }

        override fun onError(e: Throwable) {
            println("에러 발생 ${e.message}")
        }
    }

    val list = listOf("Str 1","Str 2","Str 3","Str 4")
    val observableFromIterable : Observable<String> = Observable.fromIterable(list)
    observableFromIterable.subscribe(observer)

    val callable = object : Callable<String> {
        override fun call(): String {
            return "Callable에서 왔다."
        }
    }
    val observableFromCallable: Observable<String> = Observable.fromCallable(callable)
    observableFromCallable.subscribe(observer)

    val future : Future<String> = object : Future<String> {
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
    val observableFromFuture: Observable<String> = Observable.fromFuture(future)
    observableFromFuture.subscribe(observer)
}