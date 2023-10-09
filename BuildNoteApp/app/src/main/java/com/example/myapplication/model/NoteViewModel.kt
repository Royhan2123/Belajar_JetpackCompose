package com.example.myapplication.model

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.example.myapplication.data.NotesDataSource

class NoteViewModel : ViewModel() {
    var notelist = mutableStateListOf<Note>()

    init {
        notelist.addAll(NotesDataSource().loadNotes())
    }
    fun addNote(note: Note) {
        notelist.add(note)
    }
    fun removeNote(note: Note) {
        notelist.remove(note)
    }
    fun getAllNotes(): List<Note> {
        return notelist
    }
}