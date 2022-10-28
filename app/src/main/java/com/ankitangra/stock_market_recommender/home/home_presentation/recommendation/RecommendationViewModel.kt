package com.ankitangra.stock_market_recommender.home.home_presentation.recommendation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ankitangra.core.util.*
import com.ankitangra.stock_market_recommender.core.data.RecommendationStock
import com.ankitangra.stock_market_recommender.core.domain.usecase.RecommendationEngine
import com.ankitangra.stock_market_recommender.home.home_domain.usecase.GetAllStocksUseCase
import com.ankitangra.stock_market_recommender.home.home_domain.usecase.RecommendationUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue

import kotlinx.coroutines.channels.Channel

import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch


@HiltViewModel
class RecommendationViewModel @Inject constructor(
    private val getAllStocksUseCase: GetAllStocksUseCase,
    private val getRecommendation: RecommendationUseCase
): ViewModel() {

    private val _uiEvent = Channel<UiEvent> ()
    val uiEvent = _uiEvent.receiveAsFlow()

    var currentStockState by mutableStateOf("Apple")
        private set

    var currentTimeState by mutableStateOf("10")
        private set

    var currentSocialMediaCountState by mutableStateOf("5")
        private set

    var stockSelectedState by mutableStateOf(false)
        private set

    var timeSelectedState by mutableStateOf(false)
        private set

    var socialMediaCountSelectedState by mutableStateOf(false)
        private set

    var state by mutableStateOf(RecommendationState())
        private set

    val stocks = listOf("Apple","Google","Microsoft","Netflix")
    val days = listOf("10","20","30","45","90","180","200")
    val socialCounts = listOf("2","3","4","5","<=10>","<=50","<=100")

    var allStocks = listOf<RecommendationStock>()

    init {
        fetchAllStocks()
    }

    private fun fetchAllStocks() {
        viewModelScope.launch {
            _uiEvent.send(
                UiEvent.Loading(true)
            )
            getAllStocksUseCase()
                .onSuccess {
                    _uiEvent.send(
                        UiEvent.Loading(false)
                    )
                    allStocks = it
                }
                .onFailure {
                    _uiEvent.send(
                        UiEvent.Loading(false)
                    )
                }
        }
    }


    fun onEvent(event: RecommendationScreenEvent) {
        when (event) {
            is RecommendationScreenEvent.OnStockSelected -> {
                currentStockState = event.stock
                stockSelectedState = !stockSelectedState
            }
            is  RecommendationScreenEvent.OnDaysSelected -> {
                currentTimeState = event.days
                timeSelectedState = !timeSelectedState
            }
            is RecommendationScreenEvent.OnSocialMediaCountSelected -> {
                currentSocialMediaCountState = event.value
                socialMediaCountSelectedState = !socialMediaCountSelectedState
            }
            is  RecommendationScreenEvent.OnFindClicked -> {
                val stock = allStocks.find {
                    it.symbol == currentStockState
                }
                stock?.let {
                    val recommendation = getRecommendation(it, currentTimeState.toInt(), currentSocialMediaCountState.toInt())
                    state = state.copy(
                        recommendation = recommendation
                    )
                }
            }
            is RecommendationScreenEvent.OnToggleStockSelectedState -> {
                stockSelectedState = !stockSelectedState
            }
            is RecommendationScreenEvent.OnToggleDaysSelectedState -> {
                timeSelectedState = !timeSelectedState
            }
            is RecommendationScreenEvent.OnToggleSocialMediaSelectedState -> {
                socialMediaCountSelectedState = !socialMediaCountSelectedState
            }
        }
    }

}