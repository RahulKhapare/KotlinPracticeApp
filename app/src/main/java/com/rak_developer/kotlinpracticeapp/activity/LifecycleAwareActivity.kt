package com.rak_developer.kotlinpracticeapp.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.rak_developer.kotlinpracticeapp.R
import com.rak_developer.kotlinpracticeapp.databinding.ActivityLifecycleAwareBinding
import com.rak_developer.kotlinpracticeapp.util.LifecycleObserver

class LifecycleAwareActivity : AppCompatActivity() {

    val activity = this@LifecycleAwareActivity;
    lateinit var binding: ActivityLifecycleAwareBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_lifecycle_aware);
        lifecycle.addObserver(LifecycleObserver())
        Log.e("TAG", "onCreate: " + "LifecycleOwner")
        init()
    }

    fun init() {
        (this@LifecycleAwareActivity as? AppCompatActivity)?.supportActionBar?.title =
            "Lifecycle Aware"
    }

    override fun onStart() {
        super.onStart()
        Log.e("TAG", "onStart: " + "LifecycleOwner")
    }

    override fun onResume() {
        super.onResume()
        Log.e("TAG", "onResume: " + "LifecycleOwner")
    }

    override fun onPause() {
        super.onPause()
        Log.e("TAG", "onPause: " + "LifecycleOwner")
    }

    override fun onStop() {
        super.onStop()
        Log.e("TAG", "onStop: " + "LifecycleOwner")
    }

    override fun onRestart() {
        super.onRestart()
        Log.e("TAG", "onRestart: " + "LifecycleOwner")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e("TAG", "onDestroy: " + "LifecycleOwner")
    }

    public fun showToast() {
        Toast.makeText(activity, "Toast Called", Toast.LENGTH_LONG).show()
    }
}