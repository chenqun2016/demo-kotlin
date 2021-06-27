package com.bee.sample.d

import java.lang.StringBuilder

/**
 *
 filter:保留满足条件的元素；
 map:集合中的所有元素--映射到其他元素构成新集合；
 flatMap:集合中的所有元素--映射到新集合并合并这些集合得到新集合；

 sum: 所有元素求和；
 reduce:将元素依次按规则聚合，结果与元素类型一致；
 fold：给定初始值，将元素按规则聚合，结果与初始化值类型一致；
 */
fun main(){
    val list = listOf(1,2,3)
    list.asSequence()//获取流，这样下面3步是懒汉式加载，一个循环加载一个数据。没有asSequence就是饿汉式加载，每一步都加载所有数据。
            .filter { it%2 == 0 }
            .map { it*2+1 }
            .forEach { println(it.toString()) }//懒汉式情况下，forEach是个阀门，没有这个上面的就不会调用


    list.flatMap { 0 until it }.joinToString().let (::println)


    list.reduce () { acc, i -> i+acc }
    //结果："123"
    list.fold(StringBuilder()){
        acc, i -> acc.append(i)
    }

}