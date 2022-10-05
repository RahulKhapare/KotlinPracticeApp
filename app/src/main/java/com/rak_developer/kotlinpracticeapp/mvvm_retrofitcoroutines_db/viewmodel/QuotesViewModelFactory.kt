package com.rak_developer.kotlinpracticeapp.mvvm_retrofitcoroutines_db.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.rak_developer.kotlinpracticeapp.mvvm_retrofitcoroutines_db.repository.QuotesRepository

class QuotesViewModelFactory(private val repository: QuotesRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return QuotesViewModel(repository) as T
    }
}