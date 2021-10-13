package com.hegunhee.rxkotlintest.test.chapter03

import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import java.util.*

fun main(args : Array<String>){
    val observable : Observable<Int> = Observable.range(1,5)

    observable.subscribe({
        println("Next $it")
    },{
        println("Error ${it.message}")
    },{
        println("Done")
    })

    val observer : Observer<Int> = object : Observer<Int>{
        override fun onComplete() {
            println("All Complete")
        }

        override fun onNext(t: Int) {
            println("Next $t")
        }

        override fun onError(e: Throwable) {
            println("Error Occured ${e.message}")
        }

        override fun onSubscribe(d: Disposable) {
            println("New Subscription")
        }
    }

    observable.subscribe(observer)

}