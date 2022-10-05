package com.rak_developer.kotlinpracticeapp.paging.repository

import androidx.paging.PagedList
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.liveData
import com.rak_developer.kotlinpracticeapp.paging.api.QuotesPagingAPI
import com.rak_developer.kotlinpracticeapp.paging.source.QuotesPagingSource
import javax.inject.Inject

class QuotesPagingRepository @Inject constructor(val quotesPagingAPI: QuotesPagingAPI) {

    //get Quotes Using Paging
    fun getQuotes() = Pager(
        config = PagingConfig(pageSize = 20, maxSize = 100),
        pagingSourceFactory = { QuotesPagingSource(quotesPagingAPI) }
    ).liveData

}