package com.rak_developer.kotlinpracticeapp.activity

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.rak_developer.kotlinpracticeapp.R
import com.rak_developer.kotlinpracticeapp.databinding.ActivityPagingBinding
import com.rak_developer.kotlinpracticeapp.model.MainViewModel
import com.rak_developer.kotlinpracticeapp.model.ViewModelFactory
import com.rak_developer.kotlinpracticeapp.paging.adapter.QuotesPagingAdapter
import com.rak_developer.kotlinpracticeapp.paging.viewmodel.QuotesPagingViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PagingActivity : AppCompatActivity() {

    val activity = this@PagingActivity;
    lateinit var binding: ActivityPagingBinding

    lateinit var adapter: QuotesPagingAdapter
    lateinit var quotesPagingViewModel: QuotesPagingViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_paging);
        init()
    }

    fun init() {
        (this@PagingActivity as? AppCompatActivity)?.supportActionBar?.title =
            "Paging 3"

        adapter = QuotesPagingAdapter()
        quotesPagingViewModel =
            ViewModelProvider(activity).get(QuotesPagingViewModel::class.java)

        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.setHasFixedSize(true)
        binding.recyclerView.adapter = adapter

        quotesPagingViewModel.list.observe(this, {
            adapter.submitData(lifecycle, it)
            Log.e("TAG", "init: "  + "CALLL>>>>>")
        })
    }
}