package com.rak_developer.kotlinpracticeapp.mvvm_retrofitcoroutines_db.model

import androidx.room.Entity
import androidx.room.PrimaryKey

//database is use when application is offline
@Entity(tableName = "quotestable")
data class Result(
    @PrimaryKey(autoGenerate = true)
    val quotesId: Int,
    val _id: String,
    val author: String,
    val authorSlug: String,
    val content: String,
    val dateAdded: String,
    val dateModified: String,
    val length: Int,
)