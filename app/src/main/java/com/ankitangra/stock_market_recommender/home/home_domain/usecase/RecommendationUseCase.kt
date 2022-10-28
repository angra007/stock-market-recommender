package com.ankitangra.stock_market_recommender.home.home_domain.usecase

import com.ankitangra.stock_market_recommender.R
import com.ankitangra.stock_market_recommender.core.data.RecommendationStock
import com.ankitangra.stock_market_recommender.core.domain.usecase.RecommendationEngine
import com.ankitangra.stock_market_recommender.home.home_domain.model.Recommendation
import com.ankitangra.stock_market_recommender.home.home_domain.repository.RecommendationRepository

class RecommendationUseCase(
    private val recommendationRepository: RecommendationRepository,
    private val recommendationEngine: RecommendationEngine
) {
    operator fun invoke(
        stock: RecommendationStock,
        days: Int,
        socialMediaCount: Int
    ):  List<Recommendation> {
        val result = recommendationEngine.shouldRecommend(stock, days, socialMediaCount)
        return result.map {
            val statusRes = when (it.value) {
                is RecommendationEngine.RecommendationResult.Buy ->
                    R.string.buy
                is  RecommendationEngine.RecommendationResult.Sell ->
                    R.string.sell
                is  RecommendationEngine.RecommendationResult.Hold ->
                    R.string.hold
            }
            Recommendation(it.key, statusRes)
        }
    }
}