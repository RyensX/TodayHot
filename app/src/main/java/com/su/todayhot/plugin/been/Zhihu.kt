package com.su.todayhot.plugin.been

data class Zhihu(
    val `data`: List<Data>,
    val display_num: Int,
    val fresh_text: String,
    val paging: Paging
) {

    data class Data(
        val attached_info: String,
        val card_id: String,
        val children: List<Children>,
        val debut: Boolean,
        val detail_text: String,
        val id: String,
        val style_type: String,
        val target: Target,
        val trend: Int,
        val type: String
    )

    data class Paging(
        val is_end: Boolean,
        val next: String,
        val previous: String
    )

    data class Children(
        val thumbnail: String,
        val type: String
    )

    data class Target(
        val answer_count: Int,
        val author: Author,
        val bound_topic_ids: List<Int>,
        val comment_count: Int,
        val created: Int,
        val excerpt: String,
        val follower_count: Int,
        val id: Int,
        val is_following: Boolean,
        val title: String,
        val type: String,
        val url: String
    )

    data class Author(
        val avatar_url: String,
        val headline: String,
        val id: String,
        val name: String,
        val type: String,
        val url: String,
        val url_token: String,
        val user_type: String
    )
}