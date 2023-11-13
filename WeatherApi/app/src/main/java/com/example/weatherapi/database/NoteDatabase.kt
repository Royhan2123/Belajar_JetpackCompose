package com.example.weatherapi.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.weatherapi.data.Note

@Database(entities = [Note::class], exportSchema = false, version = 1)
abstract class NoteDatabase : RoomDatabase() {
    abstract fun noteDao(): NoteDao
}