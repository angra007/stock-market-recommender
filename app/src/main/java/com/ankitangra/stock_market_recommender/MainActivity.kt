package com.ankitangra.stock_market_recommender

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.ui.Modifier
import com.ankitangra.stock_market_recommender.home.home_presentation.recommendation.RecommendationScreen
import com.ankitangra.stock_market_recommender.ui.theme.StockmarketrecommenderTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            StockmarketrecommenderTheme {
                val scaffoldState = rememberScaffoldState()
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    scaffoldState = scaffoldState,
                    content =  {
                        RecommendationScreen()
                    }
                )
            }
        }
    }
}


