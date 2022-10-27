package com.ankitangra.stock_market_recommender.home.home_data.remote.mock_remote

import com.ankitangra.stock_market_recommender.home.home_data.remote.api.StockApi
import com.ankitangra.stock_market_recommender.home.home_data.remote.dto.SocialMedia
import com.ankitangra.stock_market_recommender.home.home_data.remote.dto.Stock
import com.ankitangra.stock_market_recommender.home.home_data.remote.dto.StockDto

class StockMockRemote: StockApi {

    override suspend fun getStocks(page: String, pageSize: Int): StockDto {
        TODO("Not yet implemented")
    }

    override suspend fun getAllStocks(): StockDto = getMockStocks()

    private fun getMockStocks(): StockDto {

        val stock1 = Stock ( id = "Apple", name = "Apple", symbol = "", currency = "", value = 50.0,socialMedia = SocialMedia (
            media_count = 5
        ))

        val stock2 = Stock ( id = "Google", name = "Google", symbol = "", currency = "", value = 80.0,socialMedia = SocialMedia (
            media_count = 7
        ))

        val stock3 = Stock ( id = "Microsoft", name = "Microsoft", symbol = "", currency = "", value = 20.0,socialMedia = SocialMedia (
            media_count = 2
        ))

        val stocks = listOf(stock1, stock2, stock3)
        return StockDto(
            stocks = stocks
        )
    }
}









