package com.example.latihanviewmodel.data

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.latihanviewmodel.components.util.DataConverter
import com.example.latihanviewmodel.components.util.UUIDConverter

@Database(exportSchema = false, entities = [Note::class], version = 1)
@TypeConverters(UUIDConverter::class,DataConverter::class)
abstract class NoteDatabase:RoomDatabase() {
    abstract fun noteDao() : NoteDatabaseDao
}