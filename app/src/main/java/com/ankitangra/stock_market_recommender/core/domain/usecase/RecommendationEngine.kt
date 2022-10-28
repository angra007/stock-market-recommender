package com.ankitangra.stock_market_recommender.core.domain.usecase

import com.ankitangra.stock_market_recommender.core.data.RecommendationStock


class RecommendationEngine {

    fun shouldRecommend(
        stock: RecommendationStock,
        days: Int,
        socialMediaCount: Int
    ):  Map<String, RecommendationResult> {

        val daysArray = (0..days).toList()
        val results = HashMap<String, RecommendationResult>()

        if (socialMediaCount <= 2) {
            daysArray.forEach {
                results[it.toString()] = RecommendationResult.Sell
            }
        } else if (socialMediaCount in 3..4) {
            daysArray.forEach { index ->
                if (index % 2 == 0) {
                    results[index.toString()] = RecommendationResult.Sell
                } else {
                    results[index.toString()] = RecommendationResult.Buy
                }
            }
        } else {
            if (stock.price < 20) {
                daysArray.forEach { index ->
                    if (index % 2 == 0) {
                        results[index.toString()] = RecommendationResult.Hold
                    } else {
                        results[index.toString()] = RecommendationResult.Buy
                    }
                }
            } else {
                daysArray.forEach {
                    results[it.toString()] = RecommendationResult.Buy
                }
            }
        }

        return results
    }

    sealed class RecommendationResult {
        object Buy: RecommendationResult()
        object Sell: RecommendationResult()
        object Hold: RecommendationResult()
    }
}