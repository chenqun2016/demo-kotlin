package com.bee.sample.d

import java.io.File

fun main(){
    File("build.gradle")
            .readText()
            .toCharArray()
            .filter { it.isWhitespace() }
            .groupBy { it }
            .map { it.key to it.value.size }
            .let {
                println(it)
            }
}

//DSL:领域特定语言