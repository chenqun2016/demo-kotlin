package com.bee.sample.a

/**
1、数组
IntArray,Array<Int>
CharArray,Array<Char>
Array<String>
2、创建：intArrayOf(1,2)  IntArray(2){it}，长度 = a.size
3、遍历：for(value in array){}  array.forEach{}
4、包含：if(value in array){}  if(value !in array){}
5、arrayss.indices
 */
class 数组 {

    fun main(){

        //数组的创建
        val  d = intArrayOf(1,2,3)
        val  e = IntArray(2){it + 1}//it是数组的下标index

//        创建
        val  f = arrayOf("1","2")
        f[0] = "3"
        println("hello${f[0]}")

        val index = f.size

//        遍历
        for (i in f){
            println(i)
        }
        f.forEach { it->
            println(it)
        }
        //        遍历数组
        val arrayss = arrayOf(1,2,3)
        for(i in 0 until arrayss.size-1){

        }
//        数组的index的数组
        for(i in arrayss.indices){

        }


        if("1" in f){}

        if("1" !in f){}
    }
}