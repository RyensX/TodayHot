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

class WyHotLoader : ViewPagerData.PageLoader {

    override fun pageName(page: Int): String = "网易热榜"

    override suspend fun loadData(page: Int): List<BaseData> {
        val data = mutableListOf<BaseData>()
        apis.wyHot().data.items.forEachIndexed { index, item ->
            data.apply {
                val pageAction =
                    WebBrowserAction.obtain("https://c.m.163.com/news/a/${item.contentId}.html")
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
                add(SimpleTextData(item.title).apply {
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
                        item.img,
                        "",
                        coverHeight = 50.dp
                    ).apply {
                        spanSize = 2
                        if (index == 0)
                            paddingTop = 8.dp
                        action = pageAction
                    })
                //热度
                add(SimpleTextData("").apply { spanSize = 1 })
                add(SimpleTextData(
                    if (item.hotValue >= 1e4) "%.2f万热度".format(item.hotValue / 1e4f) else item.hotValue.toString()
                ).apply {
                    spanSize = 2
                    fontSize = 13F
                    fontStyle = 0
                    fontColor = hotTextColor
                })
                add(
                    SimpleTextData(item.source).apply {
                        spanSize = 5
                        fontSize = 13F
                        fontStyle = 0
                        fontColor = otherHotColor
                    })
            }
        }
        return data
    }

    private fun getRankColor(index: Int) =
        when (index) {
            0 -> top1HotColor
            1 -> top2HotColor
            2 -> top3HotColor
            else -> otherHotColor
        }

    private val top1HotColor = Color.parseColor("#ee1a1a")
    private val top2HotColor = Color.parseColor("#fe5d10")
    private val top3HotColor = Color.parseColor("#f5a623")
    private val otherHotColor = Color.parseColor("#999999")
    private val hotTextColor = Color.parseColor("#d66f6f")

}