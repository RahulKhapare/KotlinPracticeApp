package com.rak_developer.kotlinpracticeapp.mvvm_retrofitcoroutines_db.database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.rak_developer.kotlinpracticeapp.mvvm_retrofitcoroutines_db.model.Result
import com.rak_developer.kotlinpracticeapp.mvvmwithdb.QuotesMVVMModel

@Dao
interface QuotesDAO {

    //LiveData use to execute operation in background thread (room support live data)
    @Query("SELECT * FROM quotestable")
    fun getQuotes(): List<Result>

    //suspend tag use for perform operation background with assign task using coroutines
    @Insert
    suspend fun insertQuotes(result: List<Result>)

}