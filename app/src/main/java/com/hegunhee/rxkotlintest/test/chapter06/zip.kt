package com.hegunhee.rxkotlintest.test.chapter06

import io.reactivex.Observable

fun main(args : Array<String>){
    val observable1 = Observable.range(1,10)
    val observable2 = Observable.range(11,10)
    Observable.zip(observable1,observable2,io.reactivex.functions.BiFunction<Int,Int,Int>{
        emission01,emission02 -> emission01 + emission02
    }).subscribe{
        println("Received $it")
    }
}