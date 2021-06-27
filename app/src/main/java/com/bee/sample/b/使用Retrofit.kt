package com.bee.sample.b

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

//使用Retrofit

interface  GitHubApi{
    @GET("/repos/{owner}/{repo}")
    fun getRepository(@Path("owner") owner:String,@Path("repo") repo:String): Call<Repository>
}

fun main(){

    val getHubApi = Retrofit.Builder().baseUrl("https://api.github.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(GitHubApi::class.java)

    val response = getHubApi.getRepository("JetBrains","Kotlin").execute()

    val repository = response.body()

    if(null == repository){
        println("error!${response.code()}-${response.message()}")
    }else{
        println(repository.name)
        println(repository.node_id)
        println(repository.id)
    }
}
