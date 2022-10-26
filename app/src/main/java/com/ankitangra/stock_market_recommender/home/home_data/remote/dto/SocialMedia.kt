package com.ankitangra.stock_market_recommender.home.home_data.remote.dto

import com.squareup.moshi.Json

data class SocialMedia(
    @field:Json(name = "media_count")
    val media_count: String
)
