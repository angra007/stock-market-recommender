package com.ankitangra.stock_market_recommender.home.di

import com.ankitangra.stock_market_recommender.home.home_domain.repository.RecommendationRepository
import com.ankitangra.stock_market_recommender.home.home_domain.usecase.GetAllStocksUseCase
import com.ankitangra.stock_market_recommender.home.home_domain.usecase.RecommendationUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
class HomeModule {

    @Provides
    @ViewModelScoped
    fun provideRecommendationUseCase(
        recommendationRepository: RecommendationRepository
    ): RecommendationUseCase {
        return RecommendationUseCase(recommendationRepository)
    }

    @Provides
    @ViewModelScoped
    fun provideGetAllStocksUseCase(
        recommendationRepository: RecommendationRepository
    ): GetAllStocksUseCase {
        return GetAllStocksUseCase(recommendationRepository)
    }

}