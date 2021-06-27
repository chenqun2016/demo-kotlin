package com.bee.sample.e

import kotlin.properties.Delegates
import kotlin.reflect.KProperty

/**
代理Delegate
接口代理：对象 x 代替当前类 A 实现接口 B 的方法
属性代理： 对象 x 代替属性 a 实现 getter/setter 方法
 lazy
 observable
 */


interface Api{
    fun a()
    fun b()
}

class ApiImpl :Api{
    override fun a() {
    }

    override fun b() {
    }
}

//对象 api 代替类 ApiWrapper 实现接口 Api
//api 必须实现 Api 接口
class ApiWrapper(val api:Api):Api by api{

//    override fun a() {
//        api.a()
//    }

    override fun b() {
        println("a is called")
        api.b()
    }
}

class SuperArray<E>(
        private val list:MutableList<E?> = ArrayList(),
        private val map:MutableMap<String,E> = HashMap()
):MutableList<E?> by list,MutableMap<String,E> by map{
    override fun isEmpty(): Boolean  = list.isEmpty() && map.isEmpty()

    override val size: Int
        get() = list.size + map.size

    override fun clear() {
        list.clear()
        map.clear()
    }

    override fun set(index: Int, element: E?): E? {
        if(list.size <= index){
            repeat(index - list.size + 1){
                list.add(null)
            }
        }
        return  list.set(index,element)
    }

    override fun toString(): String {
        return list.joinToString().plus(";").plus(map.toString())
    }
}

//observable
class StateManager{
    //ObservableProperty 的实例代理了属性 state 的getter/setter
    var state:Int by Delegates.observable(0){
        property, oldValue, newValue ->
        println{"$oldValue -- $newValue"}
    }
}


class Foo{
    val x:Int by X()
    var y:Int by X()
}
class X{
    operator fun getValue(thisRef:Any?,property: KProperty<*>):Int{
        return 2
    }

    operator fun setValue(foo: Foo, property: KProperty<*>, i: Int) {

    }
}


fun main(){
    val superArray = SuperArray<String>()
    superArray += "Hello"
    superArray["Hello"] = "World"

    superArray[1] = "1"
    superArray[3] = "3"
    println(superArray)

    println(Foo().x)
}


