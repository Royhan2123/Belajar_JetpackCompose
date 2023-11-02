package com.example.latihanviewmodel.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(exportSchema = false, entities = [Note::class], version = 1)
abstract class NoteDatabase:RoomDatabase() {
    abstract fun noteDao() : NoteDatabaseDao
}