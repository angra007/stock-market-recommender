package com.ankitangra.stock_market_recommender.home.home_presentation.recommendation

import androidx.lifecycle.ViewModel
import com.ankitangra.stock_market_recommender.core.domain.model.RecommendationResult
import com.ankitangra.stock_market_recommender.core.domain.usecase.RecommendationEngine
import com.ankitangra.stock_market_recommender.home.home_domain.usecase.RecommendationUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class RecommendationViewModel @Inject constructor(
    private val getRecommendations: RecommendationUseCase,
    private val recommendationEngine: RecommendationEngine
): ViewModel() {

    fun getGreeting(): String {
        val stock = getRecommendations()
        val result = recommendationEngine(stock)
        return if (result == RecommendationResult.Buy) {
            "Buy"
        } else {
            "Sell"
        }
    }

}