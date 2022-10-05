package com.rak_developer.kotlinpracticeapp.activity

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.rak_developer.kotlinpracticeapp.R
import com.rak_developer.kotlinpracticeapp.adapter.ProgrammingListAdapter
import com.rak_developer.kotlinpracticeapp.databinding.ActivityListAdapterDiffUtilBinding
import com.rak_developer.kotlinpracticeapp.model.ProgramingModel

class ListAdapterWithDiffUtilActivity : AppCompatActivity() {

    val activity = this@ListAdapterWithDiffUtilActivity;
    lateinit var binding: ActivityListAdapterDiffUtilBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_list_adapter_diff_util);

        init()
    }

    fun init() {
        (this@ListAdapterWithDiffUtilActivity as? AppCompatActivity)?.supportActionBar?.title =
            "List Adapter With Diff Util"

        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.setHasFixedSize(true)

        setListAdapterWithDiffUtil()

    }

    fun setListAdapterWithDiffUtil() {
        val adapter = ProgrammingListAdapter()
        val p1 = ProgramingModel(1, "J", "Java")
        val p2 = ProgramingModel(3, "K", "Kotlin")
        val p3 = ProgramingModel(2, "A", "Android")
        adapter.submitList(listOf(p1, p2, p3))
        binding.recyclerView.adapter = adapter

        Handler(Looper.getMainLooper()).postDelayed({
            val p3 = ProgramingModel(2, "A", "Android")
            val p4 = ProgramingModel(2, "P", "Python")
            val p5 = ProgramingModel(2, "R", "Ruby")
            adapter.submitList(listOf(p3, p4, p5))

        }, 5000)
    }

}