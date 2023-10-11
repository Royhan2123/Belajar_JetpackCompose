package com.example.myapplication.repository

import com.example.myapplication.data.NoteDatabaseDao
import com.example.myapplication.model.Note
import javax.inject.Inject

class NoteRepository @Inject constructor(private val noteDatabaseDao: NoteDatabaseDao) {
    suspend fun addNote(note: Note) = noteDatabaseDao.insert(note)
    suspend fun updateNote(note: Note) = noteDatabaseDao.update(note)
    suspend fun deleteNot(note: Note) = noteDatabaseDao.deleteNote(note)
}