package com.example.latihanviewmodel.model

import com.example.latihanviewmodel.data.Note
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.example.latihanviewmodel.data.NotesDataSource

class NoteViewModel : ViewModel() {
    private var noteList = mutableStateListOf<Note>()

    init {
        noteList.addAll(NotesDataSource().loadNotes())
    }

    // untuk menambahkan data
    fun addNote(note:Note){
        noteList.add(note)
    }

    // untuk menghapus data
    fun removeNote(note:Note){
        noteList.remove(note)
    }

    // untuk mendapatkan semua data
    fun getAllNote():List<Note>{
        return noteList
    }
}