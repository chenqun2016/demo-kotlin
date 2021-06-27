package com.bee.sample.e

/**
内部类
 inner class Inner

 匿名内部类： object：Runnable,Cloneable{}
 */
class Outer{
    inner class Inner  //有inner 就不是静态的
    class StaticInner //静态的
}
fun main(){
    object :Runnable,Cloneable{
        override fun run() {
        }
    }
}
