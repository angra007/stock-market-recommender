package com.ankitangra.stock_market_recommender.home.home_presentation.recommendation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ankitangra.core.util.*
import com.ankitangra.stock_market_recommender.R
import com.ankitangra.stock_market_recommender.core.domain.usecase.RecommendationEngine
import com.ankitangra.stock_market_recommender.home.home_domain.usecase.RecommendationUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

@HiltViewModel
class RecommendationViewModel @Inject constructor(
    private val getRecommendations: RecommendationUseCase,
    private val recommendationEngine: RecommendationEngine
): ViewModel() {

    private val _uiEvent = Channel<UiEvent> ()
    val uiEvent = _uiEvent.receiveAsFlow()

    fun getStocks() {
        viewModelScope.launch {
            _uiEvent.send(
                UiEvent.ShowLoading
            )
        }
    }

    fun getGreeting(): UiText.StringResource {
        val stock = getRecommendations()
        val result = recommendationEngine(stock)
        return if (result == RecommendationEngine.RecommendationResult.Buy) {
            UiText.StringResource(R.string.buy)
        } else {
            UiText.StringResource(R.string.sell)
        }
    }

}