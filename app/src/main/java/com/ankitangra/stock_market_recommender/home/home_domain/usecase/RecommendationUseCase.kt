package com.ankitangra.stock_market_recommender.home.home_domain.usecase

import com.ankitangra.stock_market_recommender.core.data.RecommendationStock
import com.ankitangra.stock_market_recommender.home.home_domain.repository.RecommendationRepository

class RecommendationUseCase(
    private val recommendationRepository: RecommendationRepository
) {
    suspend operator fun invoke(
        symbol: String
    ): Result<List<RecommendationStock>>  {
        if (symbol.isBlank()) {
            return Result.success(emptyList())
        }
        return recommendationRepository.getStocks(symbol.trim())
    }
}