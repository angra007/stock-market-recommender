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

        val stock1 = Stock ( id = "1234", name = "Apple", symbol = "Apple", currency = "USD", value = 50.0,socialMedia = SocialMedia (
            media_count = 5
        ))

        val stock2 = Stock ( id = "5678", name = "Google", symbol = "Google", currency = "USD", value = 80.0,socialMedia = SocialMedia (
            media_count = 7
        ))

        val stock3 = Stock ( id = "3452", name = "Microsoft", symbol = "Microsoft", currency = "USD", value = 20.0,socialMedia = SocialMedia (
            media_count = 2
        ))

        val stock4 = Stock ( id = "4332", name = "Netflix", symbol = "Netflix", currency = "USD", value = 20.0,socialMedia = SocialMedia (
            media_count = 2
        ))

        val stocks = listOf(stock1, stock2, stock3, stock4)
        return StockDto(
            stocks = stocks
        )
    }
}









