package com.ankitangra.stock_market_recommender.home.home_data.repository

import com.ankitangra.stock_market_recommender.core.data.RecommendationStock
import com.ankitangra.stock_market_recommender.home.home_data.mapper.toRecommendationStock
import com.ankitangra.stock_market_recommender.home.home_data.remote.api.StockApi
import com.ankitangra.stock_market_recommender.home.home_domain.repository.RecommendationRepository

class RecommendationRepositoryImpl(
    private val stockApi: StockApi
): RecommendationRepository {

    override suspend fun getAllStocks(): Result<List<RecommendationStock>> {
        return try {
            val stockDto = stockApi.getAllStocks()
            val recommendedStocks = stockDto.stocks.map { it.toRecommendationStock() }
            Result.success(recommendedStocks)
        } catch (e: Exception) {
            e.printStackTrace()
            Result.failure(e)
        }
    }
}