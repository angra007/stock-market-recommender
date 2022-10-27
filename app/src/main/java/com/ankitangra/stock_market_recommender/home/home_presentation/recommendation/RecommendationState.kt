package com.ankitangra.stock_market_recommender.home.home_presentation.recommendation

import com.ankitangra.stock_market_recommender.core.data.RecommendationStock

data class RecommendationState (
      val stocks : List<RecommendationStock> = emptyList()
)