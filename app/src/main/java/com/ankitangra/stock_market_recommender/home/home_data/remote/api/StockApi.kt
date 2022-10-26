package com.ankitangra.stock_market_recommender.home.home_data.remote.api

import com.ankitangra.stock_market_recommender.home.home_data.remote.dto.StockDto


interface StockApi {

    suspend fun getStocks(
       page: String,
       pageSize: Int
    ): StockDto

    companion object {
        const val BASE_URL = ""
    }
}