package com.su.todayhot.plugin.components.loader

import com.su.mediabox.pluginapi.data.BaseData
import com.su.mediabox.pluginapi.data.SimpleTextData
import com.su.mediabox.pluginapi.data.ViewPagerData
import com.su.todayhot.plugin.apis

class ZhiHuHotLoader : ViewPagerData.PageLoader {

    override fun pageName(page: Int): String = "知乎综合热榜"

    override suspend fun loadData(page: Int): List<BaseData> = apis.zhHot().data.map {
        SimpleTextData(it.target.title)
    }

}