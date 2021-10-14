package com.hegunhee.rxkotlintest.test.chapter03

import io.reactivex.rxkotlin.toObservable

fun main(args : Array<String>){
    val connectableObservable = listOf<String>("String 1","String 2","String 3","String 4").toObservable().publish()
    connectableObservable.subscribe({println("Subscription 1 : $it")})
    connectableObservable.map(String::reversed).subscribe({println("Subscription 2 $it")})
    connectableObservable.connect()
    connectableObservable.subscribe({println("Subscription 3: $it")})
}