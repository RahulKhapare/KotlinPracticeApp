package com.rak_developer.kotlinpracticeapp.mvvm_retrofitcoroutines_db.model

data class QuotesListModel(
    val count: Int,
    val lastItemIndex: Int,
    val page: Int,
    val results: List<Result>,
    val totalCount: Int,
    val totalPages: Int
)