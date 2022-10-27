package com.ankitangra.stock_market_recommender.home.home_presentation.recommendation

sealed class RecommendationScreenEvent {
    object OnSymbolEntered: RecommendationScreenEvent()
    object OnDateEntered: RecommendationScreenEvent()
}