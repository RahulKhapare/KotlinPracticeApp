package com.rak_developer.kotlinpracticeapp.paging.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.rak_developer.kotlinpracticeapp.paging.repository.QuotesPagingRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class QuotesPagingViewModel @Inject constructor(val quotesPagingRepository: QuotesPagingRepository) :
    ViewModel() {

    val list = quotesPagingRepository.getQuotes().cachedIn(
        viewModelScope
    )
}