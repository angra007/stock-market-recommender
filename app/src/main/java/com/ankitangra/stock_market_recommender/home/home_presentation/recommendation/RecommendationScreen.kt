package com.ankitangra.stock_market_recommender.home.home_presentation.recommendation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import kotlinx.coroutines.flow.collect
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import com.ankitangra.core.util.UiEvent
import com.ankitangra.stock_market_recommender.R
import com.ankitangra.stock_market_recommender.core.ui.TopBar

@Composable
fun RecommendationScreen(
    viewModel: RecommendationViewModel = hiltViewModel()
) {

    LaunchedEffect(key1 = true) {
        viewModel.uiEvent.collect { event ->
            when (event) {
                is UiEvent.Loading -> {
                    if (event.show) {
                        println("Show")
                    } else {
                        println("Hide")
                    }
                }
                else -> Unit
            }
        }
    }

    val context = LocalContext.current

    Column(modifier = Modifier.fillMaxSize()) {
        TopBar(stringResource(id = R.string.header_title))
        Box( modifier = Modifier
            .fillMaxSize()
        ) {

        }
    }
}