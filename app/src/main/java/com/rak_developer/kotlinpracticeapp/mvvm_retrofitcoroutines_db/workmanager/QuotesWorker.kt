package com.rak_developer.kotlinpracticeapp.mvvm_retrofitcoroutines_db.workmanager

import android.content.Context
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters
import com.rak_developer.kotlinpracticeapp.mvvm_retrofitcoroutines_db.repository.QuotesApplication
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

//(check repository & application class)
class QuotesWorker(private val context: Context, parameters: WorkerParameters) :
    Worker(context, parameters) {
    override fun doWork(): Result {
        Log.e("TAG", "doWork: " + "Worker Called")
        val repository = (context as QuotesApplication).quotesRepository
        CoroutineScope(Dispatchers.IO).launch {
            repository.getQuotesBackground()
        }
        return Result.success()
    }
}