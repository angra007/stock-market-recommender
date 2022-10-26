package com.ankitangra.stock_market_recommender.home.home_data.remote.mock_remote

import com.ankitangra.stock_market_recommender.home.home_data.remote.api.StockApi
import com.ankitangra.stock_market_recommender.home.home_data.remote.dto.StockDto

class StockMockRemote: StockApi {

    override suspend fun getStocks(page: String, pageSize: Int): StockDto {
        TODO("Not yet implemented")
    }
}