package com.bee.sample.c

//operator 是运算符重载
operator fun String.minus(any:Any):String = replaceFirst(any.toString(),"")

operator fun String.times(right:Int):String{
    return (1..right).joinToString(""){it -> this}
}

operator  fun String.div(right:Any?):Int{
    val right = right.toString()
    return this.windowed(right.length,1) { it == right }.count { it }
}

fun main(){
    val str = "hello world"
    println(str.minus("world"))

    val str2 = "*"
    println(str2.times(20))
}