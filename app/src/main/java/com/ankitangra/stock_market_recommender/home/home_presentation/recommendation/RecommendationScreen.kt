package com.ankitangra.stock_market_recommender.home.home_presentation.recommendation


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import kotlinx.coroutines.flow.collect
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.ankitangra.core.util.UiEvent
import com.ankitangra.stock_market_recommender.R
import com.ankitangra.stock_market_recommender.core.ui.ExpandableTextView
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
    val localContext = LocalContext.current

    Column(modifier = Modifier.fillMaxSize()) {
        TopBar(stringResource(id = R.string.header_title))
        Box( modifier = Modifier
            .fillMaxSize()
            .padding(top = localSpacing.spaceMedium)
        ) {

            Column( modifier = Modifier.fillMaxSize()) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight(),
                    verticalArrangement = Arrangement.Top
                ) {

                    ExpandableTextView(
                        textValue = viewModel.currentStockState,
                        label = "Select a stock",
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(84.dp)
                            .padding(localSpacing.spaceExtraSmall),
                        items = viewModel.stocks,
                        expanded = viewModel.stockSelectedState,
                        onItemSelected = {
                            viewModel.onEvent(RecommendationScreenEvent.OnStockSelected(it))
                        },
                        toggleState = {
                            viewModel.onEvent(RecommendationScreenEvent.OnToggleStockSelectedState)
                        }
                    )

                    Spacer(modifier = Modifier.height(localSpacing.spaceExtraSmall))

                    ExpandableTextView(
                        textValue = viewModel.currentTimeState,
                        label = "Select a time window (Days)",
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(84.dp)
                            .padding(localSpacing.spaceExtraSmall),
                        items = viewModel.days,
                        expanded = viewModel.timeSelectedState,
                        onItemSelected = {
                            viewModel.onEvent(RecommendationScreenEvent.OnDaysSelected(it))
                        },
                        toggleState = {
                            viewModel.onEvent(RecommendationScreenEvent.OnToggleDaysSelectedState)
                        }
                    )

                    Spacer(modifier = Modifier.height(localSpacing.spaceExtraSmall))

                    ExpandableTextView(
                        textValue = viewModel.currentSocialMediaCountState,
                        label = "Select a social media count",
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(84.dp)
                            .padding(localSpacing.spaceExtraSmall),
                        items = viewModel.socialCounts,
                        expanded = viewModel.socialMediaCountSelectedState,
                        onItemSelected = {
                            viewModel.onEvent(RecommendationScreenEvent.OnSocialMediaCountSelected(it))
                        },
                        toggleState = {
                            viewModel.onEvent(RecommendationScreenEvent.OnToggleSocialMediaSelectedState)
                        }
                    )

                    Button(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(64.dp)
                            .padding(localSpacing.spaceSmall),
                        onClick = {
                            viewModel.onEvent(RecommendationScreenEvent.OnFindClicked)
                        }) {
                        Text(text = "Find")
                    }
                }

                Spacer(modifier = Modifier.height(localSpacing.spaceSmall))

                LazyColumn(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(start = localSpacing.spaceSmall, end = localSpacing.spaceSmall)
                ) {
                    items(state.recommendation) { recommendation ->

                        val day = recommendation.day
                        val status = localContext.getString(recommendation.status)

                        Text(text = "On Day: $day you should $status ")
                    }
                }
            }
        }
    }
}