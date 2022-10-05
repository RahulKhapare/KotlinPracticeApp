package com.rak_developer.kotlinpracticeapp.mvvmwithdb

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface QuotesMVVMDAO {

    //LiveData use to execute operation in background thread (room support live data)
    @Query("SELECT * FROM quote")
    fun getQuotes(): LiveData<List<QuotesMVVMModel>>

    //suspend tag use for perform operation background with assign task using coroutines
    @Insert
    suspend fun insertQuotes(quotes: QuotesMVVMModel)

    @Update
    suspend fun updateQuotes(quotes: QuotesMVVMModel)

    @Delete
    suspend fun deleteQuotes(quotes: QuotesMVVMModel)
}