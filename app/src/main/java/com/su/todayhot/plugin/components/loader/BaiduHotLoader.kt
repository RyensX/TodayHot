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

class BaiduHotLoader : ViewPagerData.PageLoader {

    override fun pageName(page: Int): String = "百度风云榜"

    override suspend fun loadData(page: Int): List<BaseData> {
        val data = mutableListOf<BaseData>()
        apis.baiduHot().data.cards.find { it.component == "hotList" }?.content?.forEachIndexed { index, content ->
            val pageAction =
                WebBrowserAction.obtain(content.url)
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
            data.add(getHotLabel(content.hotTag).apply {
                spanSize = 2
                if (this is TagData)
                    gravity = Gravity.CENTER
            })
        }
        data.first().layoutConfig = BaseData.LayoutConfig(18)
        return data
    }

    private val hotColor = Color.parseColor("#FD6621")
    private val newColor = Color.parseColor("#FF4267")

    private fun getHotLabel(label: String?): BaseData =
        when (label) {
            "1" -> TagData("新", newColor)
            "3" -> TagData("热", hotColor)
            else -> SimpleTextData("")
        }

    private val top1Color = Color.parseColor("#EB354A")
    private val top2Color = Color.parseColor("#E56D1E")
    private val top3Color = Color.parseColor("#ECAC32")
    private val otherTopColor = Color.parseColor("#84868E")

    private fun getRankColor(index: Int) = when (index) {
        0 -> top1Color
        1 -> top2Color
        2 -> top3Color
        else -> otherTopColor
    }

}