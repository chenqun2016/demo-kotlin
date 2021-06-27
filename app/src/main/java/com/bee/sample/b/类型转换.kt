package com.bee.sample.b

/**
 * 类型转换
 *
1、is 相当于java instanceOf，if(string is String){}。并且做了类型强转
2、as 相当于java的强转
（string as String).toString
强转可能失败，加？，失败返回null
(string as? String)?.toString

 建议：
 1，尽量使用val，让程序更加清晰确定
 2，尽可能减少函数对外部变量的访问，为函数式编程提供基础
 3，必要时创建局部变量指向外部变量，避免因它变化引起程序错误
 */

var tag:String? = null //公共的变量

fun main(){

    var value:String? = null
    value = "hello"
    if(value != null){
        println(value.length)//已经把String?转换成了String
    }



    //由于是公共的变量，不能强制转换
    if(tag != null){
        //因为就算程序到了这里，tag也有可能会被其他线程修改
//        println(tag.length)
    }
}