package com.hegunhee.rxkotlintest.test.functionalKt

import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.disposables.Disposable

fun main(args: Array<String>) {
    val observer = object : Observer<String> {
        override fun onComplete() {
            println("모두 완료됨")
        }

        override fun onNext(t: String) {
            println("다음 $t")
        }

        override fun onError(e: Throwable) {
            println("에러 발생 ${e.message}")
        }

        override fun onSubscribe(d: Disposable) {
            println("새로운 구독")
        }
    }

    val observable: Observable<String> = Observable.create<String> {
        it.onNext("방출됨 1")
        it.onNext("방출됨 2")
        it.onNext("방출됨 3")
        it.onNext("방출됨 4")
        it.onComplete()
    }
    observable.subscribe(observer)


    val observable2: Observable<String> = Observable.create<String> {
        it.onNext("방출됨 1")
        it.onNext("방출됨 2")
        it.onError(Exception("My Exception"))
    }
    observable2.subscribe(observer)

}