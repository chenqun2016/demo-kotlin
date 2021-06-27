package com.bee.sample.e

/**
内联类inline           typealias(类型别名,为现有类型提供替代名称)
使用场景：
1，无符号类型：UInt（对Int的包装）
2，模拟枚举：因为枚举（内部创建的对象）内存开销比较大
限制：
主构造器必须有且仅有一个只读属性
不能定义有backing-field的其它属性
被包装类型必须不能是泛型类型
不能继承父类也不能被继承
不能被定义成内部类



是对某一个类型的包装，类似java装箱类型
编译器会尽可能使用被包装的类型进行优化

 可以实现接口，不能继承父类，也不能被继承
 */
//BoxInt 对value做了包装，value必须是val，且必须定义在主构造器
inline class BoxInt(val value:Int) :Comparable<Int>{
    operator fun inc():BoxInt{
        return BoxInt(value+1)
    }

    override fun compareTo(other: Int): Int {
        return 0
    }
}

inline class State1(val ordinal:Int){
    companion object{
        val Idle = State1(0)
        val Busy = State1(2)
    }

    fun values() = arrayOf(Idle, Busy)

}




fun main(){
    val box = BoxInt(3)
    if(box < 10){//可以直接跟整型比大小
        println("a")
    }



}