package com.bee.sample.a

/**
 * 集合框架
不可变List<T>,可变MutableList<T>;  listOf,mutableListOf
不可变Map<K,V>,可变MutableMap<K,V>; mapOf,mutableMapOf
不可变Set<T>,可变MutableSet<T>

 集合的增加 ，付值

 Pair，Triple
 */
class 集合框架 {


    fun test(){
//list 创建方式
        val list =  listOf(1,2)
        val mlist = mutableListOf("1")

        for (i in 0..10){
//            两种方式一样
            mlist += "num:$i"
            mlist.add( "num:$i")
        }
        mlist[0] = "22"
        val item = mlist[0]

//map 创建方式
        val map = HashMap<String,Int>()
        map["hello"] = 1
        println(map["hello"])

        val map2 = mapOf("A" to 2,"B" to 3)


//      pair ,triple 创建方式
        val pair = "hello" to "kotlin"
        val pair2 = Pair("hello" ,"kotlin")

        val triple = Triple(1,2,3)

//      pair获取元素方式,Triple类似
        val first = pair.first
        val second = pair.second
        val(x,y) = pair


    }
}