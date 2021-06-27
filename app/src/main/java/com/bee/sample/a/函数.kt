package com.bee.sample.a

/**
 *函数
 * 变长参数
 * 默认参数
 * 多返回值
 */
class Hansu {
    fun  bar(a:String):Unit{
    }

    fun  bar(a:String,b:Int):Any{
        return 0;
    }
}

fun aa( a:(Hansu,String,Int)->Any  ):Any{
    a(Hansu(),"1",1)
    return 1
}
fun aa( a:(String,Int)->Any  ):Any{
//    函数调用的两种方式
    a.invoke("1",1)
    a("1",1)
    return 1
}

fun test(){
//    函数和方法的区别：有接收者的就是方法，没有就是函数
//    函数类型(Hansu,String) -> Any
//    引用函数的方式 ::
//    默认每个函数的第一个参数都是：自身接收者

    //三种方式都一样
    val b : (Hansu,String) -> Any = Hansu::bar
    val a: Hansu.(String) -> Unit = Hansu::bar
    val e :Function2<Hansu,String,Any> = Hansu::bar


    val c: (Hansu,String,Int)->Any = Hansu::bar

    val h = Hansu()//定义了接收者，就不用传Hansu
    val d:(String)->Any = h::bar

    aa(Hansu::bar)
    aa(h::bar)
}


//变长参数用vararg定义
fun main(vararg  a:Int):Triple<Int,Int,Int>{
//    a就相当于数组
    listOf<Int>(1,2,3)
    a.forEach { i -> println(i) }
    return Triple(1,2,3)
}

//多返回值  Pair,Triple
fun MoreParams(){
//    两种接受方式

    val  i = main(1)
    val (a,b,c) = main(2)
    val d = a+b+c
}

//默认参数
fun defaultParameter(a:Int,b:String,c:Int=1){
}
fun defaultParameter1(a:Int=2,b:String,c:Int=1){
}
fun dodefaultParameter(){
//    默认参数放最后一个参数
    defaultParameter(1,"2")
//    或者:具名参数
    defaultParameter1(b="2")
}
