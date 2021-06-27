package com.bee.sample.f

/**
 * 泛型
 *
 * 函数的泛型：fun <T> maxOf(a:T,b:T):T
 *
 * 类的泛型：sealed class List<T>
 *
 * 泛型的约束：
 *
 * 泛型的型变：
 * 泛型实参的继承关系对泛型类型的继承关系的影响
 * 1，协变：继承关系一致  ：out    ：List<out  T>
 *     协变点：函数返回值类型为泛型参数
 * 2，逆变：继承关系相反  ：in     :List<in  T>
 * 3，不变：没有继承关系
 *
 *
 */
sealed class IntList{}

sealed class List<T> {
    //泛型的型变：不变：没有继承关系
    //List<Nothing> 不是List<T>的子类，List.Nil 也不是List<T>的子类
    object Nil:List<Nothing>(){
        override fun toString(): String {
            return "Nill"
        }
    }
    data class Cons<T>(val head:T,val tail:List<T>):List <T>(){
        override fun toString(): String {
            return "$head,$tail"
        }
    }
}

//泛型的约束 单约束。必须传入 实现 Comparable 的类
fun <T:Comparable<T>> maxOf(a:T,b:T):T{
    return if(a > b) a else b
}
//泛型的约束 多约束。必须传入 1实现 Comparable ,2必须是一个函数
fun <T> callMax(a:T,b:T)
    where T:Comparable<T>,
          T:() -> Unit {
        if(a > b) a() else b()
    }
//泛型的约束 多约束，多个泛型参数
fun <T,R> callMax1(a:T,b:T)
        where T:Comparable<T>,
              T:() -> R ,
              R:Number {
    if(a > b) a() else b()
}


fun  main(){
    val max :String = maxOf("hello","world")

    val list = List.Cons(1.0,List.Nil)
}