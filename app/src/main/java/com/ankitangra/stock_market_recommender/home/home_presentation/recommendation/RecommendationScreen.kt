package com.ankitangra.stock_market_recommender.home.home_presentation.recommendation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import kotlinx.coroutines.flow.collect
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.ankitangra.core.util.UiEvent
import com.ankitangra.stock_market_recommender.R
import com.ankitangra.stock_market_recommender.core.ui.LocalSpacing
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
                        println("Show Loading Indicator")
                    } else {
                        println("Hide Loading Indicator")
                    }
                }
                else -> Unit
            }
        }
    }

    val state = viewModel.state
    val localSpacing = LocalSpacing.current

    Column(modifier = Modifier.fillMaxSize()) {
        TopBar(stringResource(id = R.string.header_title))
        Box( modifier = Modifier
            .fillMaxSize()
        ) {

            Column( modifier = Modifier.fillMaxSize()) {

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(64.dp),
                    horizontalArrangement = Arrangement.spacedBy(localSpacing.spaceMedium)
                ) {

                    Box(
                        modifier = Modifier
                            .weight(1f)
                            .fillMaxHeight()
                            .padding(start = localSpacing.spaceSmall)
                            .background(Color.Red)
                    ) {

                    }

                    Box(
                        modifier = Modifier
                            .weight(1f)
                            .fillMaxHeight()
                            .padding(end = localSpacing.spaceSmall)
                            .background(Color.Blue)
                    ) {

                    }
                }

                Spacer(modifier = Modifier.height(localSpacing.spaceSmall))

                LazyColumn(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(start = localSpacing.spaceSmall, end = localSpacing.spaceSmall)
                ) {
                    items(state.stocks) { stock ->
                        Text(text = stock.id)
                    }
                }
            }
        }
    }
}