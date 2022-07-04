package com.su.todayhot.plugin.components.loader

import android.graphics.Color
import android.graphics.Typeface
import android.view.Gravity
import com.su.mediabox.pluginapi.action.WebBrowserAction
import com.su.mediabox.pluginapi.data.BaseData
import com.su.mediabox.pluginapi.data.MediaInfo1Data
import com.su.mediabox.pluginapi.data.SimpleTextData
import com.su.mediabox.pluginapi.data.ViewPagerData
import com.su.mediabox.pluginapi.util.UIUtil.dp
import com.su.todayhot.plugin.apis

class ZhiHuHotLoader : ViewPagerData.PageLoader {

    override fun pageName(page: Int): String = "知乎综合热榜"

    override suspend fun loadData(page: Int): List<BaseData> {
        val data = mutableListOf<BaseData>()
        apis.zhHot().data.forEachIndexed { index, item ->
            data.apply {
                val pageAction =
                    WebBrowserAction.obtain("https://www.zhihu.com/question/${item.target.id}")
                //排行
                add(SimpleTextData("${index + 1}").apply {
                    spanSize = 1
                    fontColor = getRankColor(index)
                    fontSize = 22F
                    fontStyle = Typeface.BOLD
                    gravity = Gravity.CENTER_HORIZONTAL
                    if (index == 0)
                        paddingTop = 8.dp
                })
                //标题
                add(SimpleTextData(item.target.title).apply {
                    spanSize = 5
                    fontColor = Color.BLACK
                    fontStyle = Typeface.BOLD
                    if (index == 0)
                        paddingTop = 8.dp
                    action = pageAction
                })
                //配图
                add(
                    MediaInfo1Data(
                        "",
                        item.children.first().thumbnail,
                        "",
                        coverHeight = 70.dp
                    ).apply {
                        spanSize = 2
                        if (index == 0)
                            paddingTop = 8.dp
                        action = pageAction
                    })
                //热度
                add(SimpleTextData("").apply { spanSize = 1 })
                add(SimpleTextData(item.detail_text).apply {
                    spanSize = 7
                    fontSize = 13F
                    fontStyle = 0
                    fontColor = hotTextColor
                })
            }
        }
        return data
    }

    private fun getRankColor(index: Int) =
        if (index < 3) top3HotColor else otherHotColor

    private val top3HotColor = Color.parseColor("#EF3F3B")
    private val otherHotColor = Color.parseColor("#C1A468")
    private val hotTextColor = Color.parseColor("#999999")

}