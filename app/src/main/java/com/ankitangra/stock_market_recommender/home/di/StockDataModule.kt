package com.ankitangra.stock_market_recommender.home.di

import com.ankitangra.stock_market_recommender.home.home_data.remote.api.StockApi
import com.ankitangra.stock_market_recommender.home.home_data.remote.mock_remote.StockMockRemote
import com.ankitangra.stock_market_recommender.home.home_data.repository.RecommendationRepositoryImpl
import com.ankitangra.stock_market_recommender.home.home_domain.repository.RecommendationRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Named
import javax.inject.Singleton
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create

@Module
@InstallIn(SingletonComponent::class)
object StockDataModule {

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .build()
    }

//    @Provides
//    @Singleton
//    fun provideStockApi(
//        okHttpClient: OkHttpClient
//    ): StockApi {
//        return Retrofit.Builder()
//            .baseUrl(StockApi.BASE_URL)
//            .addConverterFactory(MoshiConverterFactory.create())
//            .client(okHttpClient)
//            .build()
//            .create()
//
//    }

    @Provides
    @Singleton
    fun provideStockMockApi(): StockApi {
        return StockMockRemote()
    }

    @Provides
    @Singleton
    fun provideRecommendationRepository(
        stockApi: StockApi
    ): RecommendationRepository {
        return RecommendationRepositoryImpl (
            stockApi
        )
    }
}