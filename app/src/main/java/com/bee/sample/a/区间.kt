package com.bee.sample.a

//区间
class 区间 {

    fun test(){
//        1,闭区间
//        离散值
        val intRange = 1..10 // [1,10]
        val chars = 'a'..'z'
        val longs = 1L..100L

//        连续值
        val floats = 1F..2F

//        2,开区间
        val ints = 1 until 10 //[1,10)

//        3,倒叙区间
        val intsss = 10 downTo 1 //[10,1]

//        4,区间跳步
        val ccc = 1..10 step 2

        //打印数组的每个值
        println(ccc.joinToString())




    }
}