package com.rak_developer.kotlinpracticeapp.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.rak_developer.kotlinpracticeapp.R
import com.rak_developer.kotlinpracticeapp.adapter.ProgrammingRecyclerWithBindingAdapter
import com.rak_developer.kotlinpracticeapp.adapter.ProgrammingRecyclerWithoutBindingAdapter
import com.rak_developer.kotlinpracticeapp.databinding.ActivityRecyclerViewBinding
import com.rak_developer.kotlinpracticeapp.model.ProgramingModel

class RecyclerAdapaterWithAndWithoughtBindingActivity : AppCompatActivity() {

    val activity = this@RecyclerAdapaterWithAndWithoughtBindingActivity;
    lateinit var binding: ActivityRecyclerViewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_recycler_view);

        init()
    }

    fun init() {
        (this@RecyclerAdapaterWithAndWithoughtBindingActivity as? AppCompatActivity)?.supportActionBar?.title =
            "RecyclerViewHolder With & Without Binding"

        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.setHasFixedSize(true)

//        setRecyclerViewAdapterWithoutBinding()
        setRecyclerViewAdapterWithBinding()

    }

    fun setRecyclerViewAdapterWithoutBinding() {
        // ArrayList of class ItemsViewModel
        val programmingList = ArrayList<ProgramingModel>()
        programmingList.add(ProgramingModel(1, "J", "Java"))
        programmingList.add(ProgramingModel(2, "K", "Kotlin"))
        programmingList.add(ProgramingModel(3, "A", "Android"))

        val adapter = ProgrammingRecyclerWithoutBindingAdapter(programmingList)
        binding.recyclerView.adapter = adapter

    }

    fun setRecyclerViewAdapterWithBinding() {
        // ArrayList of class ItemsViewModel
        val programmingList = ArrayList<ProgramingModel>()
        programmingList.add(ProgramingModel(1, "J", "Java"))
        programmingList.add(ProgramingModel(2, "K", "Kotlin"))
        programmingList.add(ProgramingModel(3, "A", "Android"))

        val adapter = ProgrammingRecyclerWithBindingAdapter(programmingList)
        binding.recyclerView.adapter = adapter

    }
}