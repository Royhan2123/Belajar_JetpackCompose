package com.example.latihanviewmodel.components.util

import androidx.room.TypeConverter
import androidx.room.TypeConverters
import java.sql.Timestamp
import java.util.Date

class DataConverter {
    @TypeConverter
    fun timeStampFromDate(date:Date):Long {
        return date.time
    }

    @TypeConverter
    fun dateFromTimestamp(timestamp: Long):Date {
        return Date(timestamp)
    }

}