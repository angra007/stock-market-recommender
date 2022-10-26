package com.ankitangra.stock_market_recommender.home.home_presentation.recommendation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import com.ankitangra.stock_market_recommender.R
import com.ankitangra.stock_market_recommender.core.ui.TopBar

@Composable
fun RecommendationScreen(
    viewModel: RecommendationViewModel = hiltViewModel()
) {
    Column(modifier = Modifier.fillMaxSize()) {
        TopBar(stringResource(id = R.string.header_title))
        Box( modifier = Modifier
            .fillMaxSize()
            .background(Color.Blue)) {
            Text(text = viewModel.getGreeting())
        }
    }
}