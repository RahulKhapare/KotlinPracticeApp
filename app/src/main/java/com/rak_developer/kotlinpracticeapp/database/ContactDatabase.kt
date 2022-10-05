package com.rak_developer.kotlinpracticeapp.database

import android.content.Context
import androidx.room.*
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase


//entities contain array in table form, we can declare multiple table also
@Database(entities = [ContactModel::class], version = 2)
@TypeConverters(ConvertersDatabase::class)
abstract class ContactDatabase : RoomDatabase() {

    abstract fun contactDao(): ContactDAO

    //singletant  is use to create only on object in project
    companion object {

        //Migration use to secure old database while updating database(table, column) with new version of database
        val migration_1_2 = object : Migration(1, 2) {
            override fun migrate(database: SupportSQLiteDatabase) {
                database.execSQL("ALTER TABLE contact ADD column isActive INTEGER NOT NULL DEFAULT(1)")
            }
        }

        //Volatile is updating all thread if value will update
        @Volatile
        private var INSTANCE: ContactDatabase? = null

        fun getDatabase(context: Context): ContactDatabase {
            if (INSTANCE == null) {
                //synchronized is use to create one object at a time
                synchronized(this) {
                    INSTANCE =
                        Room.databaseBuilder(
                            context.applicationContext,
                            ContactDatabase::class.java,
                            "contactBD"
                        )
                            .addMigrations(migration_1_2)
                            .build()
                }

            }
            return INSTANCE!!
        }

    }


}