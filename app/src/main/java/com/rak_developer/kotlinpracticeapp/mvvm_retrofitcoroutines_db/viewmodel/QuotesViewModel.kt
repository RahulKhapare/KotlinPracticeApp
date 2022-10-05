package com.rak_developer.kotlinpracticeapp.mvvm_retrofitcoroutines_db.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rak_developer.kotlinpracticeapp.mvvm_retrofitcoroutines_db.model.QuotesListModel
import com.rak_developer.kotlinpracticeapp.mvvm_retrofitcoroutines_db.repository.QuotesRepository
import com.rak_developer.kotlinpracticeapp.mvvm_retrofitcoroutines_db.repository.ResponseGenerics
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class QuotesViewModel(val repository: QuotesRepository) : ViewModel() {

    init {
        viewModelScope.launch(Dispatchers.IO) {
            repository.getQuotes(1)
        }
    }

//    val quotesLiveDataList: LiveData<QuotesListModel>
//        get() = repository.quotesLiveData

    val quotesLiveDataList: LiveData<ResponseGenerics<QuotesListModel>>
        get() = repository.quotesLiveData
}