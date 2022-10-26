package com.ankitangra.stock_market_recommender.core.domain.model

sealed class RecommendationResult {
    object Buy: RecommendationResult()
    object Sell: RecommendationResult()
    object Hold: RecommendationResult()
}

