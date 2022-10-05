package com.rak_developer.kotlinpracticeapp.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.rak_developer.kotlinpracticeapp.R
import com.rak_developer.kotlinpracticeapp.databinding.ActivityDataBindingAdapterBinding
import com.rak_developer.kotlinpracticeapp.model.ImageModel

class DataBindingAdapterActivity : AppCompatActivity() {

    val activity = this@DataBindingAdapterActivity;
    lateinit var binding: ActivityDataBindingAdapterBinding

    val image =
        "https://akm-img-a-in.tosshub.com/indiatoday/images/story/202209/ram_mandir_design_1200x768.jpeg?ftdkzIKpPkap9Bp55Pw0soykhhJ4syAZ&size=770:433";

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_data_binding_adapter);

        init()
    }

    fun init() {
        (this@DataBindingAdapterActivity as? AppCompatActivity)?.supportActionBar?.title =
            "Data Binding Adapter"

        val imageModel = ImageModel("Ram Mandir", "Birth Place of ram bhagavan", image)
        binding.imageModel = imageModel

    }

}