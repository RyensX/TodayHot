package com.su.todayhot.plugin.been

data class Baidu(
    val `data`: Data,
    val error: Error,
    val success: Boolean
) {
    data class Data(
        val cards: List<Card>,
        val curBoardName: String,
        val homepage: Homepage,
        val logid: String,
        val platform: String,
        val tabBoard: List<TabBoard>,
        val tag: List<Any>
    )

    data class Error(
        val code: Int,
        val message: String
    )

    data class Card(
        val component: String,
        val content: List<Content>,
        val more: Int,
        val moreAppUrl: String,
        val moreUrl: String,
        val text: String,
        val topContent: List<TopContent>?,
        val typeName: String,
        val updateTime: String
    )

    data class Homepage(
        val banner: List<Banner>,
        val cloud: List<Cloud>
    )

    data class TabBoard(
        val index: Int,
        val text: String,
        val typeName: String
    )

    data class Content(
        val appUrl: String,
        val desc: String,
        val expression: String?,
        val hotChange: String,
        val hotScore: String,
        val hotTag: String?,
        val hotTagImg: String?,
        val img: String,
        val imgSquare: String?,
        val index: Int,
        val price: String?,
        val query: String,
        val rawUrl: String,
        val show: List<String>,
        val url: String,
        val word: String
    )

    data class TopContent(
        val appUrl: String,
        val desc: String,
        val hotChange: String,
        val hotScore: String,
        val hotTag: String,
        val img: String,
        val index: Int,
        val query: String,
        val rawUrl: String,
        val show: List<Any>,
        val url: String,
        val word: String
    )

    data class Banner(
        val desc: String,
        val img: String,
        val index: Int,
        val show: List<Any>,
        val url: String,
        val word: String
    )

    data class Cloud(
        val desc: String,
        val hotScore: String,
        val index: Int,
        val show: List<Any>,
        val url: String,
        val word: String,
        val wordType: String
    )
}