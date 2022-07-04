package com.su.todayhot.plugin.been

data class Weibo(
    val `data`: Data,
    val ok: Int
) {

    data class Data(
        val hotgov: Hotgov,
        val realtime: List<Realtime>
    )

    data class Hotgov(
        val icon_desc: String,
        val icon_desc_color: String,
        val is_gov: Int,
        val is_hot: Int,
        val mid: String,
        val name: String,
        val note: String,
        val small_icon_desc: String,
        val small_icon_desc_color: String,
        val topic_flag: Int,
        val url: String,
        val word: String
    )

    data class Realtime(
        val category: String,
        val channel_type: String,
        val emoticon: String,
        val expand: Int,
        val flag: Int,
        val flag_desc: String?,
        val fun_word: Int,
        val icon_desc: String?,
        val icon_desc_color: String?,
        val is_fei: Int?,
        val is_hot: Int?,
        val is_new: Int?,
        val label_name: String?,
        val mid: String,
        val note: String,
        val num: Int,
        val onboard_time: Int,
        val rank: Int,
        val raw_hot: Int,
        val realpos: Int,
        val small_icon_desc: String?,
        val small_icon_desc_color: String?,
        val star_word: Int,
        val subject_label: String,
        val subject_querys: String,
        val topic_flag: Int,
        val word: String,
        val word_scheme: String
    )
}