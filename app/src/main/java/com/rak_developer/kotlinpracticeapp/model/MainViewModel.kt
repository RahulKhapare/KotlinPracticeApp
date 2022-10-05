package com.rak_developer.kotlinpracticeapp.model

import androidx.lifecycle.ViewModel

//class MainViewModel : ViewModel() {

class MainViewModel(val initValue: Int) : ViewModel() {

    var count: Int = initValue

    fun increment() {
        count++
    }
}