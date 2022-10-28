package com.ankitangra.stock_market_recommender.home.home_domain.model

import androidx.annotation.StringRes

data class Recommendation(
    val day: String,
    @StringRes val status: Int
)
