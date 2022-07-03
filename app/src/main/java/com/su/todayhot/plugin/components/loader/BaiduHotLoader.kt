package com.su.todayhot.plugin.components.loader

import com.su.mediabox.pluginapi.data.BaseData
import com.su.mediabox.pluginapi.data.SimpleTextData
import com.su.mediabox.pluginapi.data.ViewPagerData
import com.su.todayhot.plugin.apis

class BaiduHotLoader : ViewPagerData.PageLoader {

    override fun pageName(page: Int): String = "百度风云榜"

    override suspend fun loadData(page: Int): List<BaseData> =
        apis.baiduHot().data.cards.find { it.component == "hotList" }?.content?.map {
            SimpleTextData(it.word)
        } ?: listOf()

}