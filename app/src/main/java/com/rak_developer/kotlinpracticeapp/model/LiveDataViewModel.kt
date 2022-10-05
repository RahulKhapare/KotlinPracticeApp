package com.rak_developer.kotlinpracticeapp.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LiveDataViewModel : ViewModel() {

    val mutableLiveData = MutableLiveData<String>("This is fact")

    //live data is accessing mutable live data
    val liveData: LiveData<String>
        get() = mutableLiveData

    fun updateMutableData() {
        mutableLiveData.value = "Another fact"
    }
}