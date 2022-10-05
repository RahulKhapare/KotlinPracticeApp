package com.rak_developer.kotlinpracticeapp.database

import androidx.room.TypeConverter
import java.util.*
import kotlin.contracts.Returns

class ConvertersDatabase {

    // Type Converter is use to convert not supported value in database
    @TypeConverter
    fun fromDateToLong(value: Date): Long {
        return value.time
    }

    @TypeConverter
    fun fromLongToDate(value: Long): Date {
        return Date(value)
    }
}