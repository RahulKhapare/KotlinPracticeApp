package com.rak_developer.kotlinpracticeapp.mvvm_retrofitcoroutines_db.repository

import android.app.Application
import androidx.work.Constraints
import androidx.work.NetworkType
import androidx.work.PeriodicWorkRequest
import androidx.work.WorkManager
import com.rak_developer.kotlinpracticeapp.mvvm_retrofitcoroutines_db.api.QuotesService
import com.rak_developer.kotlinpracticeapp.mvvm_retrofitcoroutines_db.api.RetrofitHelper
import com.rak_developer.kotlinpracticeapp.mvvm_retrofitcoroutines_db.database.QuotesDatabase
import com.rak_developer.kotlinpracticeapp.mvvm_retrofitcoroutines_db.workmanager.QuotesWorker
import dagger.hilt.android.HiltAndroidApp
import java.util.concurrent.TimeUnit

// this annotation for paging
@HiltAndroidApp
class QuotesApplication : Application() {

    lateinit var quotesRepository: QuotesRepository
    override fun onCreate() {
        super.onCreate()
        initialize()
        setupWorker()
    }

    fun initialize() {
        val quotesService = RetrofitHelper.getInstance().create(QuotesService::class.java)
        val database = QuotesDatabase.getDatabase(applicationContext)
        quotesRepository = QuotesRepository(applicationContext, quotesService, database)
    }

    //WorkManager setup (check repository function & worker class)
    private fun setupWorker() {
        //check network
        val constraint = Constraints.Builder().setRequiredNetworkType(NetworkType.CONNECTED).build()
        //set time
        val workRequest =
            PeriodicWorkRequest.Builder(QuotesWorker::class.java, 20, TimeUnit.SECONDS)
                .setConstraints(constraint)
                .build()
        WorkManager.getInstance(this).enqueue(workRequest)
    }
}