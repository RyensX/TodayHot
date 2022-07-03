package com.su.todayhot.plugin

import com.su.todayhot.plugin.been.Baidu
import com.su.todayhot.plugin.been.Weibo
import com.su.todayhot.plugin.been.Zhihu
import retrofit2.http.GET

interface Apis {
    @GET("https://top.baidu.com/api/board?platform=wise&tab=realtime")
    suspend fun baiduHot(): Baidu

    @GET("https://api.zhihu.com/topstory/hot-lists/total")
    suspend fun zhHot(): Zhihu

    @GET("https://weibo.com/ajax/side/hotSearch")
    suspend fun weiboHot(): Weibo
}