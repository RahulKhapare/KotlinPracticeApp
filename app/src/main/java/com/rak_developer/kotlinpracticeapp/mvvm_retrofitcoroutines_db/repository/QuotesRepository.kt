package com.rak_developer.kotlinpracticeapp.mvvm_retrofitcoroutines_db.repository

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.rak_developer.kotlinpracticeapp.mvvm_retrofitcoroutines_db.api.QuotesService
import com.rak_developer.kotlinpracticeapp.mvvm_retrofitcoroutines_db.database.QuotesDatabase
import com.rak_developer.kotlinpracticeapp.mvvm_retrofitcoroutines_db.model.QuotesListModel
import com.rak_developer.kotlinpracticeapp.util.NetworkUtils

class QuotesRepository(
    private val context: Context,
    private val quotesService: QuotesService,
    private val quotesDatabase: QuotesDatabase
) {

//    private val quotesMutableLiveData = MutableLiveData<QuotesListModel>()
//
//    val quotesLiveData: LiveData<QuotesListModel>
//        get() = quotesMutableLiveData

    private val quotesMutableLiveData = MutableLiveData<ResponseGenerics<QuotesListModel>>()
    val quotesLiveData: LiveData<ResponseGenerics<QuotesListModel>>
        get() = quotesMutableLiveData

    suspend fun getQuotes(page: Int) {
        if (NetworkUtils.isNetworkAvailable(context)) {
            try {
                val result = quotesService.getQuotes(page)
                if (result?.body() != null) {
                    quotesDatabase.quotesDao().insertQuotes(result.body()!!.results)
//                quotesMutableLiveData.postValue(result.body())
                    quotesMutableLiveData.postValue(ResponseGenerics.Success(result.body()))
                } else {
                    quotesMutableLiveData.postValue(ResponseGenerics.Error("Response body null.."))
                }
            } catch (e: Exception) {
                quotesMutableLiveData.postValue(ResponseGenerics.Error(e.message.toString()))
            }
        } else {
            val quotess = quotesDatabase.quotesDao().getQuotes()
            val quotesList = QuotesListModel(1, 1, 1, quotess, 1, 1)
//            quotesMutableLiveData.postValue(quotesList)
            quotesMutableLiveData.postValue(ResponseGenerics.Success(quotesList))
        }

    }

    //Call Using WorkManager (check application class & worker class)
    suspend fun getQuotesBackground() {
        val randomNumber = (Math.random() * 10).toInt()
        val result = quotesService.getQuotes(randomNumber)
        if (result?.body() != null) {
            quotesDatabase.quotesDao().insertQuotes(result.body()!!.results)
//            quotesMutableLiveData.postValue(result.body())
        }
    }

}
