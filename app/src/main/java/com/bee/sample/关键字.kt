package com.bee.sample

//inline 函数内联，将内联函数的函数体（编译时期）复制到调用处实现内联。
/**
by:委托模式
语法定义:val/var <Property name> :<Type>by  <expression>代理类
使用场景:
A.延迟加载属性(lazy property): 属性值只在初次访问时才会计算,
B.可观察属性(observable property): 属性发生变化时, 可以向监听器发送通知,
C.将多个属性保存在一个 map 内, 而不是保存在多个独立的域内.


 */
class Person{

    fun main(){
        this::class.java.classLoader;
    }
}