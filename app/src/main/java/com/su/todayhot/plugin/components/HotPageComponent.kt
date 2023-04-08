package com.su.todayhot.plugin.components

import com.su.mediabox.pluginapi.components.ICustomPageDataComponent
import com.su.mediabox.pluginapi.data.BaseData
import com.su.mediabox.pluginapi.data.ViewPagerData
import com.su.todayhot.plugin.components.loader.BaiduHotLoader
import com.su.todayhot.plugin.components.loader.WeiboHotLoader
import com.su.todayhot.plugin.components.loader.WyHotLoader
import com.su.todayhot.plugin.components.loader.ZhiHuHotLoader

class HotPageComponent : ICustomPageDataComponent {

    override val pageName: String get() = "今热"

    override fun isShowBack(): Boolean = false

    override suspend fun getData(page: Int): List<BaseData>? =
        if (page == 1)
            listOf(
                ViewPagerData(
                    listOf(
                        ZhiHuHotLoader(),
                        BaiduHotLoader(),
                        WeiboHotLoader(),
                        WyHotLoader()
                    )
                ).apply {
                    layoutConfig = BaseData.LayoutConfig(itemSpacing = 0)
                })
        else null
}