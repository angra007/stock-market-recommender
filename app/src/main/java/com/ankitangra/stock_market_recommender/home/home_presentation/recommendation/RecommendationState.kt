package com.ankitangra.stock_market_recommender.home.home_presentation.recommendation

import com.ankitangra.stock_market_recommender.home.home_domain.model.Recommendation

data class RecommendationState (
      val recommendation : List<Recommendation> = emptyList()
)