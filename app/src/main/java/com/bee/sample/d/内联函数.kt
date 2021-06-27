package com.bee.sample.d

/**
 * 内联函数
 * inline
 *  高阶函数更适合用inline
 *
 *  通过crossinline/noinline  来禁止 non-local return
 *
 *  内联属性
 *  没有backing-field的属性的getter/setter可以被内联
 *
 *内联函数的限制：
 * public/protected 的内联方法只能访问对应类的public成员
 * 内联函数的内联函数参数不能被存储（赋值给变量）
 */
//内联函数 如下：
//inline fun  IntArray.forEach(action:(Int)->Unit):Unit {
//    for (ele in this) action.invoke (ele)
//}

fun main(){

    val ints = intArrayOf(1,2,4)

    ints.forEach { println("hello:$it") }
    //forEach是内联函数，内联之后相当于：  优化了性能
//    for (ele in ints) println("hello:$ele")


    //内联高阶函数的return
    ints.forEach {
        if(2 == it) return@forEach  //it ==2 的时候 跳到下次；@forEach是添加了标签；local return
        println("hello:$it") }
}