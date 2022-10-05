package com.rak_developer.kotlinpracticeapp.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.rak_developer.kotlinpracticeapp.R
import com.rak_developer.kotlinpracticeapp.databinding.ActivityDataBindingBinding
import com.rak_developer.kotlinpracticeapp.model.NameBindingModel

class DataBindingActivity : AppCompatActivity() {

    val activity = this@DataBindingActivity;
    lateinit var binding: ActivityDataBindingBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_data_binding);

        init()
    }

    fun init() {
        (this@DataBindingActivity as? AppCompatActivity)?.supportActionBar?.title =
            "View Model"

        val nameModel = NameBindingModel("Rahul", "Khapare")
        binding.name = nameModel

    }

}