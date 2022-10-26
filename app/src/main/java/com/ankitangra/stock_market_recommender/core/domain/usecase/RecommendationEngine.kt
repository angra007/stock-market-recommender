package com.ankitangra.stock_market_recommender.core.domain.usecase

import com.ankitangra.stock_market_recommender.core.data.Stock
import com.ankitangra.stock_market_recommender.core.domain.model.RecommendationResult


class RecommendationEngine {

    operator fun invoke(stock: Stock): RecommendationResult {
        return RecommendationResult.Buy
    }

}