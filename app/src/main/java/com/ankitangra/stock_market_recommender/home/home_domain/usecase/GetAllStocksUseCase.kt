package com.ankitangra.stock_market_recommender.home.home_domain.usecase

import com.ankitangra.stock_market_recommender.core.data.RecommendationStock
import com.ankitangra.stock_market_recommender.home.home_domain.repository.RecommendationRepository

class GetAllStocksUseCase (
    private val recommendationRepository: RecommendationRepository
) {

    suspend operator fun invoke(): Result<List<RecommendationStock>> = recommendationRepository.getAllStocks()

}