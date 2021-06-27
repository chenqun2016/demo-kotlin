package com.bee.sample.c

import java.lang.Exception

/**
 * 变量，常量
 val b = 3只读变量
 var b = 2 可读可写

 const val b=3 常量
 只能定义在全局范围
 只能修饰基本类型
 必须立即用字面量初始化

表达式
 if()else{}

 when(){}

 try{}catch{}
 */
fun main(){
     val b = 3 // 相当于 final int b=3


//    if else
    var c = if(b == 3) 4 else 5

//    when
    var d =  when(b){
        0 -> 11
        1 -> 12
        else -> 20
    }
    when{
        0==b -> d =11
        1==b -> d =12
        else -> d =20
    }

    d =  when(val input = readLine()){
        null -> 0
        else -> input.length
    }

//    try catch
    try {
        d = c / b
    }catch (e:Exception){
        d = 0
    }
//    或者
    d = try {
        c/b
    }catch (e:Exception){
        0
    }
}