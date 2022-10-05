package com.rak_developer.kotlinpracticeapp.mvvmwithdb

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class QuotesMVVMViewModelFactory(private val quotesRepository: QuotesMVVMRepository) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return QuotesMVVMViewModel(quotesRepository) as T
    }
}