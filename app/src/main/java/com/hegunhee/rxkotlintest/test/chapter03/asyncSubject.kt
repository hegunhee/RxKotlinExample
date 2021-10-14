package com.hegunhee.rxkotlintest.test.chapter03

import io.reactivex.Observable
import io.reactivex.subjects.AsyncSubject

fun main(args : Array<String>){
    val observable = Observable.just(1,2,3,4)
    val subject = AsyncSubject.create<Int>()
    observable.subscribe(subject)
    subject.subscribe({
        println("Received $it")
    },{
        it.printStackTrace()
    },{
        println("Complete")
    })
    subject.onComplete()

    val subject2 = AsyncSubject.create<Int>()
    subject2.onNext(1)
    subject2.onNext(2)
    subject2.onNext(3)
    subject2.onNext(4)
    subject2.subscribe({
        println("S1 Received $it")
    },{
        it.printStackTrace()
    },{
        println("S1 Complete")
    })
    subject2.onNext(5)
    subject2.subscribe({
        println("S2 Received $it")
    },{
        it.printStackTrace()
    },{
        println("S2 Complete")
    })
    subject2.onComplete()

}