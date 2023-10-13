package com.example.myapplication.components.util

import androidx.room.TypeConverter
import java.util.Date

class DateConverter {
    @TypeConverter
    fun timeStampFromDate(date:Date):Long {
        return date.time
    }
    @TypeConverter
    fun dataeFromTimeStamp(timestamp: Long):Date {
        return Date(timestamp)
    }
}