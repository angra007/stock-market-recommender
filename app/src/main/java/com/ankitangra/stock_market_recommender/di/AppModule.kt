package com.ankitangra.stock_market_recommender.di

import com.ankitangra.stock_market_recommender.core.domain.usecase.RecommendationEngine
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideRecommendationEngine(): RecommendationEngine {
        return RecommendationEngine()
    }
}