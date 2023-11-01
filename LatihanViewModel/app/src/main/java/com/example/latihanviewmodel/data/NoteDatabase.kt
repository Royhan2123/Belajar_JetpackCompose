package com.example.latihanviewmodel.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(exportSchema = false, version = 1, entities = [Note::class])
abstract class NoteDatabase : RoomDatabase() {
    abstract fun noteDao(): NoteDatabaseDao
}