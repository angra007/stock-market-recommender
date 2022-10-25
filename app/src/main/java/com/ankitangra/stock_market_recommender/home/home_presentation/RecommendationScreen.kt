package com.ankitangra.stock_market_recommender.home.home_presentation

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun RecommendationScreen(
    viewModel: RecommendationViewModel = hiltViewModel()
) {
    Text(text = viewModel.getGreeting())
}