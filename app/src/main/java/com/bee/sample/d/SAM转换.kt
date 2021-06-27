package com.bee.sample.d

import java.util.concurrent.Executor

/**
 * SAM转换
 *
 * 一个参数类型为只有一个方法的java接口的方法调用时
 * 可用Lambda表达式做转换作为参数
 *
 * 注意是java接口，Kotlin 接口不支持
 *
 * 匿名内
 * object:Runnable{...}
 * 匿名内的简写
 */
fun main(){


    val e = Executor(){}
    //下面两种匿名内部类的方式
    e.execute(object :Runnable{
        override fun run() {
            println("kotlin")
        }
    })


    fun Runnable(block:()->Unit):Runnable{
        return object :Runnable{
            override fun run() {
                block()
            }
        }
    }
    //下面是简写,原理看上面方法
    e.execute(Runnable{
        println("kotlin")
    })


    //也可以这样写lambda//原理是创建Runnable并包装()->Unit 类型的函数
    e.execute { println("kotlin") }
}