package com.ankitangra.stock_market_recommender.core.data

data class Stock (
    val id: String,
    val symbol: String,
    val price: String,
    val value: String,
    val currency: String,
    val socialMedia: SocialMedia
)

data class SocialMedia(
    val mediaCount: String,
)
