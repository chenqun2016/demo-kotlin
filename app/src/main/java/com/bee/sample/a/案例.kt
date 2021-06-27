package com.bee.sample.a

fun main(vararg  args :String){
    if(args.size < 3){
        return showHelp()
    }

    val map = mapOf(
    "+" to ::add,
    "-" to ::remove,
    "*" to ::times,
    "/" to ::div)

    val s = args[1]
    val cal = map[s]?:return showHelp()

    try {
        println("Input:${args.joinToString("")}")
        println("Output:${cal(args[0].toInt(),args[2].toInt())}")
    } catch (e: Exception) {

        showHelp()
    }

}

fun add (a:Int ,b:Int):Int{
    return a+b
}
fun remove (a:Int ,b:Int):Int{
    return a-b
}
fun times (a:Int ,b:Int):Int{
    return a*b
}
fun div (a:Int ,b:Int):Int{
    return a/b
}

fun showHelp() {
    println("""
        
        Simple Calculator
            Input: 3*4
            Output: 12
       
    """.trimIndent())
}
