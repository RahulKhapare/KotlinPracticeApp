package com.rak_developer.kotlinpracticeapp.paging.di

import com.rak_developer.kotlinpracticeapp.mvvm_retrofitcoroutines_db.api.RetrofitHelper
import com.rak_developer.kotlinpracticeapp.paging.api.QuotesPagingAPI
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class NetworkModule {

    val BASE_URL = "https://quotable.io/"

    @Singleton
    @Provides
    fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun getQuotesAPI(retrofit: Retrofit): QuotesPagingAPI {
        return retrofit.create(QuotesPagingAPI::class.java)
    }
}