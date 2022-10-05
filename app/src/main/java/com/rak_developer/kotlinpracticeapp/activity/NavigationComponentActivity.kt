package com.rak_developer.kotlinpracticeapp.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.rak_developer.kotlinpracticeapp.R
import com.rak_developer.kotlinpracticeapp.databinding.ActivityNavigationBinding

class NavigationComponentActivity : ComponentActivity() {

    val activity = this@NavigationComponentActivity;
    lateinit var binding: ActivityNavigationBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_navigation);
        init()
    }

    fun init() {
        (this@NavigationComponentActivity as? AppCompatActivity)?.supportActionBar?.title =
            "Navigation"
    }
}