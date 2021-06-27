package com.bee.sample.b

import java.io.File

/**
 * 空类型安全
 * var nullable:String? = null
 * ?. :表示可以为null
 * !! :表示强转为不可空类型，不安全，不建议使用
 * ?:   elvis 类似 boolean?a:b表达式
 * String！ 平台类型，调用其他语言时提示:如java。无法声明，使用时需判空
 */


fun main(){

    var nonNull:String = "hello"
//    nonNull = null  //String类型 不能null


    var nullable:String? = null//?表示可以为null
    val length2:Int? = nullable?.length//nullable可空，导致length2也可空
    val length3 = nullable?.length ?:0//elvis 类似 boolean?a:b表达式，这样length3就是不可空的了。

    val length = nullable!!.length//!! :表示强转为不可空类型，不安全，不建议使用


    // 父类可以接受子类 所以String是String?的子类
    var x:String = "hello"
    var y:String? = "world"
//    x = y //Type mismatch
//    y = x //OK


    val file = File("abc")
    val files = file.listFiles()//File！平台类型，可能为空
    val size = files?.size   //可以+?，也可以在java中标注 @NotNull
}