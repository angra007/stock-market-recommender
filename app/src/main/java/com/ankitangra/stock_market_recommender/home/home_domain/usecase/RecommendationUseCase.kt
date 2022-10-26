package com.ankitangra.stock_market_recommender.home.home_domain.usecase

import com.ankitangra.stock_market_recommender.core.data.SocialMedia
import com.ankitangra.stock_market_recommender.core.data.Stock
import javax.inject.Inject

class RecommendationUseCase @Inject constructor() {

    operator fun invoke(): Stock  {
        val socialMedia = SocialMedia(
            mediaCount = "40"
        )

        val stock = Stock(
            id = "zsss",
            symbol = "USD",
            price = "60",
            value = "dd",
            currency = "ddd",
            socialMedia = socialMedia
        )

        return stock

    }
}