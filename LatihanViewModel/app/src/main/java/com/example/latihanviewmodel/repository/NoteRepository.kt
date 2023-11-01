package com.example.latihanviewmodel.repository

import com.example.latihanviewmodel.data.Note
import com.example.latihanviewmodel.data.NoteDatabaseDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.conflate
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

/**
 * TODO
 *  NOTE REPOSITORY BERFUNGSI UNTUK MEMBANGUN ULANG LOGIKA DARI DAO.
 *
 */
class NoteRepository @Inject constructor(private val noteDatabaseDao: NoteDatabaseDao) {
    suspend fun addNote(note:Note) = noteDatabaseDao.insert(note)
    suspend fun updateNote(note: Note) = noteDatabaseDao.update(note)
    suspend fun deleteNote(note: Note) = noteDatabaseDao.deleteNote(note)
    suspend fun deleteAllNote() = noteDatabaseDao.deleteAll()
    suspend fun getAllNotes(): Flow<List<Note>> = noteDatabaseDao.getNotes().flowOn(Dispatchers.IO).conflate()
}