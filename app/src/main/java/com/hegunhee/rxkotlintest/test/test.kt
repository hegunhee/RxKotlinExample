package com.hegunhee.rxkotlintest.test

import android.util.Log
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.rxkotlin.toObservable
import io.reactivex.subjects.PublishSubject
import io.reactivex.subjects.Subject

fun main(args: Array<String>) {
    var subject : Subject<Int> = PublishSubject.create()
    subject.map { isEven(it) }.subscribe({
        println(("The number is ${(if (it) "Even" else "Odd")}"))
    })

    subject.onNext(4)
    subject.onNext(9)
}
fun isEven(data : Int) = data%2 == 0