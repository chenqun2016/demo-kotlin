package com.bee.sample.c

class Person(val age: Int, val name: String){
    override fun equals(other: Any?): Boolean {
        if (other is Person){
            return other.age == age && other.name == name
        }else{
            return false
        }

//        val ot = (other as? Person)?:return false
//
//        return ot.age == age && ot.name == name
    }

    override fun hashCode(): Int {
        var result = age
        result = 31 * result + name.hashCode()
        return result
    }
}

fun main() {
    val persons = HashSet<Person>()

    val person = Person(10,"zhangfei")
    persons += person

    val person2 = Person(person.age,"liguang")
    persons += person2

    println(persons.size)
}