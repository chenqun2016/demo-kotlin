package com.bee.sample.c

/**
 * Lambda 表达式
 * 就是一个匿名函数
 * 根据左边的函数类型来进行右边{}里的智能判断
 *
 * 其实Lambda {}是函数的最后一个参数，而最后一个参数
 * 又可以移到外面去。
 */

//普通函数
fun func(){
}
fun func(a:Int):String{
    return a.toString()
}
//匿名函数,类型和普通函数一样,没有函数名字
//调用方式func()
val func:()->Unit = fun (){}



val lambda:()-> String = {
    println("Hello")
    //最后一行是表达式的返回值
    "hello"
}

//下面几种方式一样
val f1 = {a:Int ->
    "hello:$a"
}
val f2:Function1<Int,String> = {a:Int ->
    "hello:$a"
}
val f3:(Int)->String = {a:Int ->
    "hello:$a"
}
val f4:(Int)->String = {
    "hello:$it"
}

val array = IntArray(5){it+1}  //后面{} 也是lambda
