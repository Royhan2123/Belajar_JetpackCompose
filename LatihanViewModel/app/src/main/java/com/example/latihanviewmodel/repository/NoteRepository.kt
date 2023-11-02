package com.example.latihanviewmodel.repository

import com.example.latihanviewmodel.data.Note
import com.example.latihanviewmodel.data.NoteDatabaseDao
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class NoteRepository @Inject constructor(private val noteDatabaseDao: NoteDatabaseDao) {
    suspend fun addNote(note:Note) = noteDatabaseDao.insert(note)
    suspend fun updateNote(note:Note) = noteDatabaseDao.update(note)
    suspend fun deleteNote(note:Note) = noteDatabaseDao.deleteNote(note)
    suspend fun deleteAll() = noteDatabaseDao.deleteAll()
    suspend fun getAllNotes(): Flow<List<Note>> = noteDatabaseDao.getNotesByAll()
}