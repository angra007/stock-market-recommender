package com.ankitangra.stock_market_recommender.core.domain.usecase

import com.ankitangra.stock_market_recommender.core.data.RecommendationStock


class RecommendationEngine {

    operator fun invoke(stock: RecommendationStock): RecommendationResult {
        return RecommendationResult.Buy
    }

    sealed class RecommendationResult {
        object Buy: RecommendationResult()
        object Sell: RecommendationResult()
        object Hold: RecommendationResult()
    }
}