package com.bee.sample.b

/**
 * 扩展方法,属性
 *
 *

扩展成员：
1.扩展方法，无法保存状态
2.扩展属性，没有field，无法保存状态.可以通过类里的其他属性来存储操作。
接口里的属性也没有field，无法保存状态
property = backing field + getter + setter
backing field = 是状态，是存储的空间
property是行为
接口可以有行为，但是不能有存储的空间
 */

class b {
//    private修饰的属性无法被拓展属性获取
    private var po :Double = 0.0
    var pocket :Double = 0.0
}
fun b.noMoney(){}
var b.money :Double
    get() {
        return 0.0 //或者：return pocket
//        return po  //private，不可访问
    }
    set(value) {
        pocket = value
    }


//String就是receiver
fun String.isEmail():Boolean{
    return true
}

//给String 添加count个Char（空格）
fun String.padding(count:Int,char: Char=' '):String{
    val padding = (1..count).joinToString(""){it->
        char.toString()
    }
    return "${padding}${this}${padding}"
}
//给String 循环多少次
fun String.times(count: Int):String{
    return (1..10).joinToString(""){this}
}

fun main(){
    println("admin@chen.com".isEmail())

    println ("hello".padding(10))//结果："          hello         "

    println("*".times(10))//结果："**********"
}