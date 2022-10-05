package com.rak_developer.kotlinpracticeapp.paging.source

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.rak_developer.kotlinpracticeapp.mvvm_retrofitcoroutines_db.model.Result
import com.rak_developer.kotlinpracticeapp.paging.api.QuotesPagingAPI

class QuotesPagingSource(val quotesPagingAPI: QuotesPagingAPI) : PagingSource<Int, Result>() {

    override fun getRefreshKey(state: PagingState<Int, Result>): Int? {
        return state.anchorPosition?.let {
            state.closestPageToPosition(it)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(it)?.nextKey?.minus(1)
        }

        //same as above but in deep
//        if (state.anchorPosition != null) {
//            val anchorPage = state.closestPageToPosition(state.anchorPosition!!)
//            if (anchorPage?.prevKey != null) {
//                return anchorPage.prevKey!!.plus(1)
//            } else if (anchorPage?.nextKey != null) {
//                return anchorPage.nextKey!!.minus(1)
//            }
//        } else {
//            return null
//        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Result> {
        try {
            val position = params.key ?: 1
            val response = quotesPagingAPI.getQuotes(position)
            return LoadResult.Page(
                data = response.body()!!.results,
                prevKey = if (position == 1) null else position - 1,
                nextKey = if (position == response.body()!!.totalPages) null else position + 1
            )
        } catch (e: Exception) {
            return LoadResult.Error(e)
        }
    }

}