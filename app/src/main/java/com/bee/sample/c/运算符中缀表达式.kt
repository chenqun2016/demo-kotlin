package com.bee.sample.c

/**
 * 运算符 中缀表达式

== 与 equals
+ 与 plus
-     minus
in 与 contains
[] 与 get/set
> 与 compareTo
() 与 invoke


中缀表达式，需求：
1，调用的方法只有一个参数。
2，用infix修饰,表示可以简写。
3，有receiver：比如Int.
infix fun Int.add(I:Int):Int{
return this + i
}
普通调用：var i = 1.add(2)
中缀表达式：var i = 1 add 2

 */

infix fun <A,B> A.to(that:B):Pair<A,B> = Pair(this,that)
val b = 2.to(3)
val a = 2 to 3


//中缀表达式 案例
class Son
class Father

infix fun Father.daerzi(son:Son){
}
val son = Son()
val father = Father()
val result = father daerzi son
