package com.bee.sample.e

/**
数据类 data

不可被继承

 使用NoArg插件 生产主构造器
 使用 AllOpen插件 去掉final

 @PoKo



 枚举：enum class State
android中不建议使用枚举，内存开销比较大
建议使用静态常量


 密封类 sealed class
特殊的抽象类
子类只能定义在与自身相同的文件中


 密封类：子类继承，子类可数，类型差异
 枚举类：类实例化，实例可数，值差异

 */
//定义在主构造器中的属性又称为 component
data class Book(val id:Long,val name:String)


enum class State{
 IDLE,BUSY
}



enum class Color{
 White,Red,Green,Blue,Yellow
}


sealed class PlayerState{
    //所有构造器私有，不能外部继承
    constructor()
    constructor(a :Int)
}

fun main(){
//    数据类
    val book = Book(1,"haha")
    val id = book.component1()
    val name = book.component2()
    //编译器还基于component 自动生成 equals/hashcode/toString/copy

    val pair = "hello" to "world"
    val(hello,world) = pair


//    枚举
    //给枚举定义扩展
    fun State.next():State{
        return State.values().let {
            val nextOrdinal = (ordinal +1) % it.size
            it[nextOrdinal]
        }
    }

    val  state = State.IDLE
    //    条件分支：
    val value = when(state){
        State.IDLE -> 0
        State.BUSY -> 1
    }

    //枚举的比较
    if(state <= State.IDLE){
    }


    //枚举的区间
    val colorRange = Color.White .. Color.Green
    val color = Color.Blue
    color in colorRange

//    密封类
}