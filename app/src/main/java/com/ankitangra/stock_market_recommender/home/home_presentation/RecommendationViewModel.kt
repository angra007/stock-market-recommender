package com.ankitangra.stock_market_recommender.home.home_presentation

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class RecommendationViewModel @Inject constructor(

): ViewModel() {

    fun getGreeting(): String = "Hello World"

}