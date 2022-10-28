package com.ankitangra.stock_market_recommender.home.home_domain.repository

import com.ankitangra.stock_market_recommender.core.data.RecommendationStock

interface RecommendationRepository {
    suspend fun getAllStocks(): Result<List<RecommendationStock>>
}