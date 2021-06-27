package com.bee.sample.e

import android.app.Activity
import android.widget.TextView
import com.bee.sample.R

/**
 * 延迟初始化：
 * 1，使用？
 * private var name :String? = null
 * 2，lateinit:
 * 会让编译器忽略变量的初始化，比支持Int等基本类型
 * 不要在复杂的逻辑中使用lateinit
 * 3，by lazy  (推荐)
 */
class activity :Activity(){

    private var name :String

    init {
        name = "1"
    }

    fun getN():String{
        return name
    }

    //接口 Lazy 的实例代理了对象 activity 的实例的属性 firstName 的 getter
    private val nameView :TextView by lazy {
        //这段只有在nameView首次被访问时执行
       findViewById(R.id.tv_text)
    }
}