package com.su.todayhot.plugin.been

data class Wangyi(
    val code: Int,
    val `data`: Data,
    val message: String
) {

    data class Data(
        val items: List<Item>,
        val more: Boolean
    )

    data class Item(
        val category: String,
        val click: Int,
        val clickRatio: Double,
        val commentCount: Int,
        val contentId: String,
        val firstShowedTime: String,
        val hotValue: Int,
        val img: String,
        val imgType: Int,
        val imgUrls: List<String>,
        val ptcount: Int,
        val ptime: String,
        val source: String,
        val threadVote: Int,
        val title: String,
        val type: String,
        val videoInfo: VideoInfo,
        val votecount: Int
    )

    data class VideoInfo(
        val cover: String,
        val length: Int,
        val title: String,
        val vid: String,
        val video_data: VideoData
    )

    data class VideoData(
        val duration: Int,
        val hd_preload_size: Int,
        val hd_size: Int,
        val hd_url: String,
        val hevc_hdpreload_size: Int,
        val hevc_preload_size: Int,
        val hevc_shdpreload_size: Int,
        val hevc_size: Int,
        val hevc_url: String,
        val hideAd: Boolean,
        val knowledgeVideo: Int,
        val play_info: List<PlayInfo>,
        val ratio: Double,
        val sd_preload_size: Int,
        val sd_size: Int,
        val sd_url: String,
        val shd_preload_size: Int,
        val shd_size: Int,
        val shd_url: String,
        val soloVideo: String
    )

    data class PlayInfo(
        val encode_format: String,
        val label: String,
        val preload_size: Int,
        val quality_desc: String,
        val quality_index: Int,
        val size: Int,
        val url: String
    )
}