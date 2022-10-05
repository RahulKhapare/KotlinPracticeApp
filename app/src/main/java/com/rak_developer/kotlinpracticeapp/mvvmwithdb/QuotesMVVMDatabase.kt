package com.rak_developer.kotlinpracticeapp.mvvmwithdb

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [QuotesMVVMModel::class], version = 1)
//@TypeConverters(ConvertersDatabase::class)
abstract class QuotesMVVMDatabase : RoomDatabase() {

    abstract fun quotesDao(): QuotesMVVMDAO

    //singletant  is use to create only on object in project
    companion object {

        //Migration use to secure old database while updating database(table, column) with new version of database
//        val migration_1_2 = object : Migration(1, 2) {
//            override fun migrate(database: SupportSQLiteDatabase) {
//                database.execSQL("ALTER TABLE contact ADD column isActive INTEGER NOT NULL DEFAULT(1)")
//            }
//        }

        //Volatile is updating all thread if value will update
        @Volatile
        private var INSTANCE: QuotesMVVMDatabase? = null

        fun getDatabase(context: Context): QuotesMVVMDatabase {
            if (INSTANCE == null) {
                //synchronized is use to create one object at a time
                synchronized(this) {
                    INSTANCE =
                        Room.databaseBuilder(
                            context.applicationContext,
                            QuotesMVVMDatabase::class.java,
                            "quotesDB"
                        )
//                            .addMigrations(migration_1_2)
                            .createFromAsset("quotes.db")//adding database from assets folder
                            .build()
                }

            }
            return INSTANCE!!
        }

    }
}