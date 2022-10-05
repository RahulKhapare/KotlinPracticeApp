package com.rak_developer.kotlinpracticeapp.activity

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.room.Room
import com.rak_developer.kotlinpracticeapp.R
import com.rak_developer.kotlinpracticeapp.database.ContactDatabase
import com.rak_developer.kotlinpracticeapp.database.ContactModel
import com.rak_developer.kotlinpracticeapp.databinding.ActivityRoomDatabaseBinding
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.util.*

class RoomDatabaseActivity : AppCompatActivity() {

    val activity = this@RoomDatabaseActivity;
    lateinit var binding: ActivityRoomDatabaseBinding

    lateinit var database: ContactDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_time_date_view)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_room_database);
        init()
    }

    fun init() {
        (this@RoomDatabaseActivity as? AppCompatActivity)?.supportActionBar?.title =
            "Room Database"

//        database =
//            Room.databaseBuilder(applicationContext, ContactDatabase::class.java, "contactBD")
//                .build()

        database = ContactDatabase.getDatabase(this)

        //coroutines to launch database in background thread
        GlobalScope.launch {
            database.contactDao().insertContact(ContactModel(0, "Rahul", "0000000000", Date(),1))
        }

        binding.btnGetData?.setOnClickListener {
            getContactData()
        }

    }

    fun getContactData() {
        database.contactDao().getContact().observe(this, {
            var dataValue = it.toString()
            Log.e("TAG", "getContactData: " + dataValue)
            Toast.makeText(activity, dataValue, Toast.LENGTH_SHORT).show()
        })
    }

}