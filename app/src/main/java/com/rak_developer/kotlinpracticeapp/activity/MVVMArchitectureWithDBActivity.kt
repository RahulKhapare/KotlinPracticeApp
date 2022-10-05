package com.rak_developer.kotlinpracticeapp.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.rak_developer.kotlinpracticeapp.R
import com.rak_developer.kotlinpracticeapp.databinding.ActivityMvvmArchitectureDbBinding
import com.rak_developer.kotlinpracticeapp.mvvmwithdb.*

class MVVMArchitectureWithDBActivity : AppCompatActivity() {

    val activity = this@MVVMArchitectureWithDBActivity;
    lateinit var binding: ActivityMvvmArchitectureDbBinding
    lateinit var quotesViewModel: QuotesMVVMViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_mvvm_architecture_db);

        init()
    }

    fun init() {
        (this@MVVMArchitectureWithDBActivity as? AppCompatActivity)?.supportActionBar?.title =
            "MVVM Architecture With DB"

        val dao = QuotesMVVMDatabase.getDatabase(applicationContext).quotesDao()

        val repository = QuotesMVVMRepository(dao)

        quotesViewModel = ViewModelProvider(
            this,
            QuotesMVVMViewModelFactory(repository)
        ).get(QuotesMVVMViewModel::class.java)

        //set data to data binding class
        quotesViewModel.getQuotes().observe(this, {
            binding.quotes = it.toString()
        })

        binding.btnAddQuotes?.setOnClickListener {
            val quotesModel = QuotesMVVMModel(0, "This is for testing", "Testing")
            quotesViewModel.insertQuotes(quotesModel)
        }
    }
}