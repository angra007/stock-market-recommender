package com.ankitangra.stock_market_recommender.core.domain.usecase

import com.ankitangra.stock_market_recommender.core.data.RecommendationStock


class RecommendationEngine {

    operator fun invoke(stock: RecommendationStock): RecommendationResult {
        return if (stock.price > 80.0 && stock.socialMedia.mediaCount > 5) {
            RecommendationResult.Buy
        } else if (stock.price >= 50.0  && stock.socialMedia.mediaCount > 5) {
            RecommendationResult.Sell
        } else {
            RecommendationResult.Hold
        }
    }

    sealed class RecommendationResult {
        object Buy: RecommendationResult()
        object Sell: RecommendationResult()
        object Hold: RecommendationResult()
    }
}