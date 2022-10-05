package com.rak_developer.kotlinpracticeapp.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.rak_developer.kotlinpracticeapp.R
import com.rak_developer.kotlinpracticeapp.databinding.ActivityDataBindingWithLiveDataBinding
import com.rak_developer.kotlinpracticeapp.model.DataBindingModel

class DataBindingWithLiveDataActivity : AppCompatActivity() {

    val activity = this@DataBindingWithLiveDataActivity;
    lateinit var binding: ActivityDataBindingWithLiveDataBinding

    lateinit var dataBindingModel: DataBindingModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =
            DataBindingUtil.setContentView(this, R.layout.activity_data_binding_with_live_data);
        init()
    }

    fun init() {
        (this@DataBindingWithLiveDataActivity as? AppCompatActivity)?.supportActionBar?.title =
            "Data Binding With Live Data With One & Two Way"

        dataBindingModel = ViewModelProvider(this).get(DataBindingModel::class.java)
        binding.dataBindingModel = dataBindingModel
        binding.lifecycleOwner = this

    }
}