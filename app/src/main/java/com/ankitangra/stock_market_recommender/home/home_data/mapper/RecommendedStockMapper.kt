package com.ankitangra.stock_market_recommender.home.home_data.mapper

import com.ankitangra.stock_market_recommender.core.data.RecommendationSocialMedia
import com.ankitangra.stock_market_recommender.core.data.RecommendationStock
import com.ankitangra.stock_market_recommender.home.home_data.remote.dto.SocialMedia
import com.ankitangra.stock_market_recommender.home.home_data.remote.dto.Stock

fun Stock.toRecommendationStock(): RecommendationStock {
    return RecommendationStock(
        id,
        symbol,
        value,
        currency,
        socialMedia.toRecommendationSocialMedia()
    )
}

fun SocialMedia.toRecommendationSocialMedia(): RecommendationSocialMedia {
    return RecommendationSocialMedia(
        mediaCount = media_count
    )
}
