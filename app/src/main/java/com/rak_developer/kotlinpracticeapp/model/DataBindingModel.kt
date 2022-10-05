package com.rak_developer.kotlinpracticeapp.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class DataBindingModel : ViewModel() {

    var mutableLiveData = MutableLiveData<String>("User Name")

    //live data is accessing mutable live data
    val liveData: LiveData<String>
        get() = mutableLiveData

    fun updateData() {
        mutableLiveData.value = "Rahul Khapare"
    }
}