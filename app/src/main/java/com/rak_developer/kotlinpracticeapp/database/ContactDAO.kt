package com.rak_developer.kotlinpracticeapp.database

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface ContactDAO {

    //suspend tag use for perform operation background with assign task using coroutines
    @Insert
    suspend fun insertContact(contact: ContactModel)

    @Update
    suspend fun updateContact(contact: ContactModel)

    @Delete
    suspend fun deleteContact(contact: ContactModel)

    //LiveData use to execute operation in background thread (room support live data)
    @Query("SELECT * FROM contact")
    fun getContact(): LiveData<List<ContactModel>>

}
