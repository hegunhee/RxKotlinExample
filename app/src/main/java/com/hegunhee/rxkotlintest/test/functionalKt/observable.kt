package com.hegunhee.rxkotlintest.test.functionalKt

import io.reactivex.rxkotlin.toObservable

fun main(args : Array<String>){
    var list = listOf(1,"둘",3,"넷","다섯",5.5f)
    var observable = list.toObservable()

    observable.subscribe({
        //onNext ->
        println(it)
    },{
        //onError ->
        it.printStackTrace()
    },{
        //onComplete ->
        println("완료")
    })
}