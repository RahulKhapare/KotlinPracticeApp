package com.rak_developer.kotlinpracticeapp.mvvmwithdb

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class QuotesMVVMViewModel(private val quotesRepository: QuotesMVVMRepository) : ViewModel() {

    fun getQuotes(): LiveData<List<QuotesMVVMModel>> {
        return quotesRepository.getQuotes()
    }

    fun insertQuotes(quotes: QuotesMVVMModel) {
        viewModelScope.launch(Dispatchers.IO) {
            quotesRepository.insertQuotes(quotes)
        }

    }
}