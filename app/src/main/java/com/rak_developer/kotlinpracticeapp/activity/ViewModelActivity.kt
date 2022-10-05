package com.rak_developer.kotlinpracticeapp.activity

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.rak_developer.kotlinpracticeapp.R
import com.rak_developer.kotlinpracticeapp.databinding.ActivityViewModelBinding
import com.rak_developer.kotlinpracticeapp.model.MainViewModel
import com.rak_developer.kotlinpracticeapp.model.ViewModelFactory

class ViewModelActivity : AppCompatActivity(), View.OnClickListener {

    val activity = this@ViewModelActivity;
    lateinit var binding: ActivityViewModelBinding

    lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_view_model);

        //without view model factory
//        mainViewModel = ViewModelProvider(activity).get(MainViewModel::class.java)

        //with view model factory (use to pass argument)
        mainViewModel =
            ViewModelProvider(activity, ViewModelFactory(10)).get(MainViewModel::class.java)
        init()
    }

    fun init() {
        (this@ViewModelActivity as? AppCompatActivity)?.supportActionBar?.title =
            "View Model"

        setText()
        binding.btnAddCounter?.setOnClickListener(activity)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btnAddCounter -> {
                updateCount()
            }
        }
    }

    fun setText() {
        binding.txtCounter.text = mainViewModel.count.toString()
    }

    fun updateCount() {
        mainViewModel.increment()
        setText()
    }

}