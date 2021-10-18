package com.hegunhee.rxkotlintest.test.functionalKt

import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.disposables.Disposable

fun main(args : Array<String>){
    val observable : Observable<Int> = Observable.range(1,5)

    observable.subscribe({
        println("다음 -> $it")
    },{
        println("에러 -> ${it.message}")
    },{
        println("완료")
    })

    val observer : Observer<Int> = object : Observer<Int> {
        override fun onComplete() {
            println("모두 완료됨")
        }

        override fun onNext(t: Int) {
            println("다음 -> $t")
        }

        override fun onError(e: Throwable) {
            println("에러 발생-> ${e.message}")
        }

        override fun onSubscribe(d: Disposable) {
            println("새로운 구독")
        }
    }

    observable.subscribe(observer)
}