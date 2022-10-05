package com.rak_developer.kotlinpracticeapp.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.rak_developer.kotlinpracticeapp.R
import com.rak_developer.kotlinpracticeapp.databinding.ActivityLayoutViewBinding
import com.rak_developer.kotlinpracticeapp.databinding.ActivityMainBinding
import com.rak_developer.kotlinpracticeapp.databinding.ActivityTextViewBinding

class LayoutViewActivity : AppCompatActivity() {

    val activity = this@LayoutViewActivity;
    lateinit var binding: ActivityLayoutViewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_layout_view)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_layout_view);
        init()
    }

    fun init() {
        (this@LayoutViewActivity as? AppCompatActivity)?.supportActionBar?.title = "Layout View "
    }
}