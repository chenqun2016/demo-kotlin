package com.bee.sample.e

import java.io.File
import java.io.FileInputStream
import java.lang.Exception
import java.net.URL
import java.util.*
import kotlin.reflect.KProperty

class PropertiesDelegate(private val path:String,private val defaultValue:String =""){
    private lateinit var url :URL

    private val properties:Properties by lazy {
        val prop  = Properties()
        url = try {
            javaClass.getResourceAsStream(path).use {
                prop.load(it)
            }
            javaClass.getResource(path)
        }catch (e :Exception){
            try {
                ClassLoader.getSystemClassLoader().getResourceAsStream(path).use {
                    prop.load(it)
                }
                ClassLoader.getSystemClassLoader().getResource(path)!!
            }catch (e :Exception){
                FileInputStream(path).use {
                    prop.load(it)
                }
                URL("file://${File(path).canonicalFile}")
            }
        }
        prop
    }

    operator fun getValue(thisRef:Any?,property: KProperty<*>):String{
        return properties.getProperty(property.name,defaultValue)
    }

    operator fun setValue(thisRef: Any?, property: KProperty<*>, value: String){
        properties.setProperty(property.name,value)
        File(url.toURI()).outputStream().use {
            properties.store(it,"保存一次")
        }
    }

    abstract  class  AbsProperties(path:String){
        protected val prop = PropertiesDelegate(path)
    }

    class Config: AbsProperties("Config.properties"){
        var author by prop
    }

}

fun main(){
    val config = PropertiesDelegate.Config()
    println(config.author)
    config.author = "haha"
    println(config.author)
}