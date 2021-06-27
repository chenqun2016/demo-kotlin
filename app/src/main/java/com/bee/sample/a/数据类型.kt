package com.bee.sample.a

/**
 * CTRL+SHIFT+P 查看数据类型
 * CTRL+SHIFT+T Suround with : Try catch/if else ...
 * 基本数据类型
 */
class ab {
    //基本数据类型Byte,Short,Int,Long,Float,Double,Char,String
    //无符号（兼容C语言）数据类型UByte,UShort,UInt,ULong,UFloat,UDouble,UChar,UString
    val a:String = "1"  // val声明不可变变量 ==final
    var b:String = "1"  // var声明可变变量
    var c = "1"// 变量类型可以自动推导

    var d = 111L  //Long 必须大写

    //val e : Int = d  //隐式类型转换--不被允许

    fun test():String{
        println(a == b)//比较的值
        println(a === b)//比较的引用

        //模板，不用加  \n  换行
        val n = """
            
            
        """.trimIndent()//此方法去除空格

        //字符串的拼接：  $param或者 ${object.param}
        println("hello,$a")
        println("hello,${test()}")

        return "1"
    }

}