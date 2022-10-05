package com.rak_developer.kotlinpracticeapp.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.rak_developer.kotlinpracticeapp.R
import com.rak_developer.kotlinpracticeapp.databinding.ActivityLiveDataBinding
import com.rak_developer.kotlinpracticeapp.model.LiveDataViewModel

class LiveDataActivity : AppCompatActivity() {

    val activity = this@LiveDataActivity;
    lateinit var binding: ActivityLiveDataBinding

    lateinit var liveDataViewModel: LiveDataViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_live_data);
        init()
    }

    fun init() {
        (this@LiveDataActivity as? AppCompatActivity)?.supportActionBar?.title =
            "Live Data"

        liveDataViewModel = ViewModelProvider(this).get(LiveDataViewModel::class.java)

        //mutavle livedata
//        liveDataViewModel.mutableLiveData.observe(this, {
//            binding.txtMessage.text = it
//        })

//        live data
        liveDataViewModel.liveData.observe(this, {
            binding.txtMessage.text = it
        })

        binding.btnUpdate?.setOnClickListener() {
            liveDataViewModel.updateMutableData()
        }

    }
}