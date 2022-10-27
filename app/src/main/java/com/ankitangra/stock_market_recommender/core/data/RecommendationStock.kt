package com.ankitangra.stock_market_recommender.core.data

data class RecommendationStock (
    val id: String,
    val symbol: String,
    val value: String,
    val currency: String,
    val socialMedia: RecommendationSocialMedia
)

data class RecommendationSocialMedia(
    val mediaCount: Int,
)
