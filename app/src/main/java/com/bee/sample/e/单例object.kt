package com.bee.sample.e

/**
object单例
定义单例，类加载时实例化对象

kotlin上没有静态成员
 两个注解 实现跨平台：
 @JvmField
 @JvmStatic
 */

//Singleton既是类名 也是 对象名
object Singleton {
    var x :Int = 2//java代码中调用方法：Singleton.INSTANCE.x;
    @JvmStatic fun y(){}//java代码中调用方法：Singleton.y();
}

fun main(){
    Singleton.x
    Singleton.y()
}