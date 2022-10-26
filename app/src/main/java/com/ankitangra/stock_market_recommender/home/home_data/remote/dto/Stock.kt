package com.ankitangra.stock_market_recommender.home.home_data.remote.dto

import com.squareup.moshi.Json

data class Stock(
    @field:Json(name = "id")
    val id: String,

    @field:Json(name = "name")
    val name: String,

    @field:Json(name = "symbol")
    val symbol: String,

    @field:Json(name = "currency")
    val currency: String,

    @field:Json(name = "value")
    val value: String,

    @field:Json(name = "socialMedia")
    val socialMedia: SocialMedia
)


