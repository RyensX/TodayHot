package com.su.todayhot.plugin.components.loader

import com.su.mediabox.pluginapi.data.BaseData
import com.su.mediabox.pluginapi.data.SimpleTextData
import com.su.mediabox.pluginapi.data.ViewPagerData
import com.su.todayhot.plugin.apis

class WeiboHotLoader : ViewPagerData.PageLoader {
    override fun pageName(page: Int): String = "微博热搜榜"

    override suspend fun loadData(page: Int): List<BaseData> = apis.weiboHot().data.realtime.map {
        SimpleTextData(it.word)
    }
}