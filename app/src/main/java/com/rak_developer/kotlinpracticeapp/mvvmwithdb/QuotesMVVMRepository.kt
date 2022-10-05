package com.rak_developer.kotlinpracticeapp.mvvmwithdb

import androidx.lifecycle.LiveData

class QuotesMVVMRepository(val quotesDAO: QuotesMVVMDAO) {

    fun getQuotes(): LiveData<List<QuotesMVVMModel>> {
        return quotesDAO.getQuotes()
    }

    suspend fun insertQuotes(quotes: QuotesMVVMModel) {
        return quotesDAO.insertQuotes(quotes)
    }
}