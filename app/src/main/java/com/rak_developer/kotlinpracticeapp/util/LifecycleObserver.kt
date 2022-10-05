package com.rak_developer.kotlinpracticeapp.util

import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import com.rak_developer.kotlinpracticeapp.activity.LifecycleAwareActivity
import com.rak_developer.kotlinpracticeapp.databinding.ActivityLifecycleAwareBinding

class LifecycleObserver : LifecycleObserver {


    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun onCreate() {
        Log.e("TAG", "onCreate: " + "LifecycleObserver")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun onStart() {
        Log.e("TAG", "onStart: " + "LifecycleObserver")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun onResume() {
        Log.e("TAG", "onResume: " + "LifecycleObserver")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    fun onPause() {
        Log.e("TAG", "onPause: " + "LifecycleObserver")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    fun onStop() {
        Log.e("TAG", "onStop: " + "LifecycleObserver")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun onDestroy() {
        Log.e("TAG", "onDestroy: " + "LifecycleObserver")
    }
}