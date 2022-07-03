package com.su.todayhot.plugin.components.loader

import android.graphics.Color
import android.graphics.Typeface
import android.view.Gravity
import com.su.mediabox.pluginapi.action.WebBrowserAction
import com.su.mediabox.pluginapi.data.BaseData
import com.su.mediabox.pluginapi.data.SimpleTextData
import com.su.mediabox.pluginapi.data.TagData
import com.su.mediabox.pluginapi.data.ViewPagerData
import com.su.mediabox.pluginapi.util.UIUtil.dp
import com.su.todayhot.plugin.apis

class WeiboHotLoader : ViewPagerData.PageLoader {
    override fun pageName(page: Int): String = "微博热搜榜"

    override suspend fun loadData(page: Int): List<BaseData> {
        val data = mutableListOf<BaseData>()
        val totalCount = 18
        apis.weiboHot().data.realtime.forEachIndexed { index, content ->
            val pageAction =
                WebBrowserAction.obtain("https://s.weibo.com/weibo?q=%23${content.word}%23&Refer=top")
            //排名
            data.add(SimpleTextData("${index + 1}").apply {
                spanSize = 2
                fontSize = 16F
                fontColor = getRankColor(index)
                fontStyle = Typeface.BOLD
                gravity = Gravity.CENTER
            })
            //标题
            data.add(SimpleTextData(content.word).apply {
                spanSize = 14
                fontColor = Color.BLACK
                fontStyle = Typeface.BOLD
                paddingTop = 4.dp
                paddingBottom = 4.dp
                action = pageAction
            })
            //标签
            data.add(getHotLabel(content.label_name).apply {
                spanSize = 2
                if (this is TagData)
                    gravity = Gravity.CENTER
            })
        }
        data.first().layoutConfig = BaseData.LayoutConfig(totalCount)
        return data
    }

    private val hotColor = Color.parseColor("#FF9406")
    private val newColor = Color.parseColor("#FF3852")
    private val businessColor = Color.parseColor("#00B7EE")
    private val boilColor = Color.parseColor("#F86400")

    private fun getHotLabel(label: String?): BaseData =
        when (label) {
            "新" -> TagData(label, newColor)
            "热" -> TagData(label, hotColor)
            "商" -> TagData(label, businessColor)
            "沸" -> TagData(label, boilColor)
            else -> SimpleTextData("")
        }

    private val topColor = Color.parseColor("#F26D5F")
    private val otherTopColor = Color.parseColor("#FF9A29")

    private fun getRankColor(index: Int) = when (index) {
        0, 1, 2 -> topColor
        else -> otherTopColor
    }
}