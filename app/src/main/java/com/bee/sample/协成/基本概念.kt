package com.bee.sample.协成

import com.bee.sample.b.Repository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import kotlin.coroutines.Continuation

/**
 * 协程基本概念
 * （非阻塞）挂起，恢复 可以控制执行流程的转移
 * 异步逻辑，同步写法
 * 同步代码比异步代码更灵活，更容易实现复杂业务
 *
 * 按调用栈分类：
 * 有栈协程：每个协程分配单独调用栈，类似线程的调用栈
 * 无栈协程：不会分配单独的调用栈，挂起点状态通过闭包或对象保存
 *
 * 按调用关系：
 * 对称协程：调度权可以转移给任意协程，协程之间是对等关系
 * 非对称协程：调度权只能转移给调用自己的协程，协程存在父子关系
 */
interface  GitHubApi{
    @GET("/repos/{owner}/{repo}")
    fun getRepository(@Path("owner") owner:String, @Path("repo") repo:String): Call<Repository>

    @GET("/repos/{owner}/{repo}")
    suspend fun getRepository2(@Path("owner") owner:String, @Path("repo") repo:String): String
}

suspend fun main(){

    val getHubApi = Retrofit.Builder().baseUrl("https://api.github.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(GitHubApi::class.java)

    val call = getHubApi.getRepository("JetBrains","Kotlin");

    call.enqueue(object : Callback<String>{
        override fun onFailure(call: Call<String>, t: Throwable) {
            println(t.message)
        }

        override fun onResponse(call: Call<String>, response: Response<String>) {
            println(response.message())
        }
    })
    val str = getHubApi.getRepository2("JetBrains","Kotlin");
    try {
        println(str)
    }catch (e :Exception){
        println(e.message)
    }


    val arrayOf = arrayOf("1", "2", "3")
    val results = arrayOf.map { name->getHubApi.getRepository2(name,"Kotlin") }

    Continuation<>()
}