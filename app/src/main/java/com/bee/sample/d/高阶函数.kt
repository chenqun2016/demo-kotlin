package com.bee.sample.d

import com.bee.sample.R
import java.io.Closeable

/**
 * 高阶函数：1参数包含函数类型，2返回函数类型；就叫高阶函数
 简单讲：函数套函数

 几个有用的高阶函数：let，run，also，apply，use

//返回表达式结果
let   val r = X.let{x -> R}
run   val r = X.run{this:X -> R}
//返回Receiver
also  val x = X.also{x -> Unit}
apply  val x = X.apply{this:X -> Unit}
//自动关闭资源
use   val r = Closeable.use{c -> R} 给所有可以关闭的对象使用,

 */
fun needsFunction(block:()->Unit){
}
fun returnsFunction():()->Int{
    return {String.hashCode()}
}


inline fun  IntArray.forEach(action:(Int)->Unit):Unit {
    for (ele in this) action.invoke (ele)
}

inline fun <R> IntArray.map(transform:(Int)->R):List<R>{
    return mapTo(ArrayList<R>(size),transform)
}


fun main(){
    val t =  intArrayOf(1,2)
    t.forEach (::println)//可传递action:(Int)->Unit类型的函数
    t.forEach { it+1 }//函数类型是最后一个参数，可以移出来，并省略空的()

    val d = t.map { it.toString() }

}