package com.ankitangra.stock_market_recommender.home.home_presentation.recommendation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ankitangra.core.util.*
import com.ankitangra.stock_market_recommender.R
import com.ankitangra.stock_market_recommender.core.domain.usecase.RecommendationEngine
import com.ankitangra.stock_market_recommender.home.home_domain.usecase.GetAllStocksUseCase
import com.ankitangra.stock_market_recommender.home.home_domain.usecase.RecommendationUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

@HiltViewModel
class RecommendationViewModel @Inject constructor(
    private val getAllStocksUseCase: GetAllStocksUseCase,
    private val getRecommendations: RecommendationUseCase,
    private val recommendationEngine: RecommendationEngine
): ViewModel() {

    private val _uiEvent = Channel<UiEvent> ()
    val uiEvent = _uiEvent.receiveAsFlow()

    init {
        fetchStocks()
    }

    private fun fetchStocks() {
        viewModelScope.launch {
            _uiEvent.send(
                UiEvent.Loading(show = true)
            )
            getAllStocksUseCase()
                .onSuccess {
                    _uiEvent.send(
                        UiEvent.Loading(show = false)
                    )
                    println("Here is the list")
                }
                .onFailure {
                    it.printStackTrace()
                    _uiEvent.send(
                        UiEvent.Loading(show = false)
                    )
                    println("Here is the error")
                }
        }
    }

    fun queryStock(
        query: String
    ) {
       viewModelScope.launch {
            val stock = getRecommendations(symbol = query)
       }
    }

}