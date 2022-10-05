package com.rak_developer.kotlinpracticeapp.mvvm_retrofitcoroutines_db.api

import com.rak_developer.kotlinpracticeapp.mvvm_retrofitcoroutines_db.model.QuotesListModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface QuotesService {


    // for more api methods - https://github.com/lukePeavey/quotable
    @GET("/quotes")
    suspend fun getQuotes(@Query("page") page: Int): Response<QuotesListModel>
}