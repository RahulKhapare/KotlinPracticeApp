package com.rak_developer.kotlinpracticeapp.activity

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.rak_developer.kotlinpracticeapp.R
import com.rak_developer.kotlinpracticeapp.databinding.ActivityMvvmRetrofitCoroutinesDbBinding
import com.rak_developer.kotlinpracticeapp.mvvm_retrofitcoroutines_db.api.QuotesService
import com.rak_developer.kotlinpracticeapp.mvvm_retrofitcoroutines_db.api.RetrofitHelper
import com.rak_developer.kotlinpracticeapp.mvvm_retrofitcoroutines_db.repository.QuotesApplication
import com.rak_developer.kotlinpracticeapp.mvvm_retrofitcoroutines_db.repository.ResponseGenerics
import com.rak_developer.kotlinpracticeapp.mvvm_retrofitcoroutines_db.viewmodel.QuotesViewModel
import com.rak_developer.kotlinpracticeapp.mvvm_retrofitcoroutines_db.viewmodel.QuotesViewModelFactory
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MVVMRetrofitWithCoroutinesAndDatabaseActivity : AppCompatActivity() {

    val activity = this@MVVMRetrofitWithCoroutinesAndDatabaseActivity;
    lateinit var binding: ActivityMvvmRetrofitCoroutinesDbBinding

    lateinit var quotesViewModel: QuotesViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =
            DataBindingUtil.setContentView(this, R.layout.activity_mvvm_retrofit_coroutines_db);
        init()
    }

    fun init() {
        (this@MVVMRetrofitWithCoroutinesAndDatabaseActivity as? AppCompatActivity)?.supportActionBar?.title =
            "MVVM Retrofit With Coroutines DB"

        //application class need to add in manifest application
        //it will run when app will start, use to declare common object, so no need to call object everytime
        val quotesRepository = (application as QuotesApplication).quotesRepository
        quotesViewModel = ViewModelProvider(
            this,
            QuotesViewModelFactory(quotesRepository)
        ).get(QuotesViewModel::class.java)

        quotesViewModel.quotesLiveDataList.observe(this, {
//            Log.e("TAG", "quotesAPI_DATA: " + it.results.toString())
//            val result = it.results
//            if (result != null) {
//                val quotesListModel = result
//                quotesListModel?.forEach {
//                    Log.e("TAG", "quotesAPI_Author: " + it.author)
//                }
//            }

            when (it) {
                is ResponseGenerics.Loading -> {
                    //show loader
                    showToast("Loading.....")
                }
                is ResponseGenerics.Success -> {
                    //bind result
                    it.data?.let {
                        showToast(it.results.size.toString())
                        val result = it.results
                        if (result != null) {
                            val quotesListModel = result
                            quotesListModel?.forEach {
                                Log.e("TAG", "quotesAPI_Author: " + it.author)
                            }
                        }
                    }
                }
                is ResponseGenerics.Error -> {
                    //show error
                    showToast(it.errorMessage.toString())
                }
            }


        })

    }


    // not good way to use
    fun directRetrofitCall() {
        val quotesAPI = RetrofitHelper.getInstance().create(QuotesService::class.java)
        GlobalScope.launch {
            val result = quotesAPI.getQuotes(1)
            if (result != null) {
                Log.e("TAG", "quotesAPI: " + result.body().toString())
                val quotesListModel = result.body()
//                if (quotesListModel != null) {
//
//                }
                quotesListModel?.results?.forEach {
                    Log.e("TAG", "quotesAPI_Author: " + it.author)
                }
            }
        }
    }

    fun showToast(message: String) {
        Toast.makeText(activity, message, Toast.LENGTH_LONG).show()
    }
}