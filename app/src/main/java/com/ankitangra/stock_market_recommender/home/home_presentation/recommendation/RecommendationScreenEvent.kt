package com.ankitangra.stock_market_recommender.home.home_presentation.recommendation

sealed class RecommendationScreenEvent {
    data class OnStockSelected(var stock: String): RecommendationScreenEvent()
    data class OnDaysSelected(var days: String): RecommendationScreenEvent()
    object OnToggleStockSelectedState: RecommendationScreenEvent()
    object OnToggleDaysSelectedState: RecommendationScreenEvent()
    object OnFindClicked: RecommendationScreenEvent()
}