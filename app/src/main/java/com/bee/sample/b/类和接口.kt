package com.bee.sample.b

/**
 * 类和接口
 *
 * 默认都是Public final修饰
 * open是final反义词；修饰 类/方法 可以被 继承/覆写
 *
 * 属性
 * property = backing field + getter + setter
 */


//跟class名后面是：主构造器，constructor可以去掉。
// 所有副构造器都必须调用主构造器
open class a constructor(var x: Int,val y:String) :SimpleAbsA(),SimpleInf {
//    var x:Int = 0
//    副构造器
//    constructor(x: Int) {
//        this.x = x
//    }

    override fun infMethod() {
    }

    override fun absMethod() {
    }

//    由于父类中是open的，所以这里也可以被子类继承
//    可以用final 禁止子类继承
    override final fun overridable() {
        super.overridable()
    }

    override val simpleProperty: Int
        get()  = 2
}

class a2(x: Int, y: String) : a(x, y) {
    override val simpleProperty: Int
        get()  = 2

//    override fun overridable() {
//        super.overridable()
//    }
}

//方法默认不可以被覆写
//open修饰类/方法 可以被覆写
abstract class  SimpleAbsA{
    abstract fun  absMethod()
//    可以被覆写
    open fun overridable() {}
//    不可以被覆写
    fun nonOverridable(){}
}

interface SimpleInf{
    fun infMethod()
    val simpleProperty : Int
}


fun main(){
    val bean = a2(1,"hello")

    println("say:${bean.y}")



//    分为绑定receiver和未绑定的情况
    val person = Person(1,"chen")
    val ageRef = person::age
    ageRef.set(2)
    val age = ageRef.get()

    val ageRef2 = Person::age
    val age2 = ageRef2.get(person)
}


//类的属性：
//跟函数一样属性也有引用
//引用：val ageRef = Person::age
class Person(age:Int,name:String){
    //var：get和set方法是默认就有的，field就相当于age
    //val:没有set方法
    var age:Int = age
    get() {
        return field
    }
    set(value) {
        field = value
    }

}