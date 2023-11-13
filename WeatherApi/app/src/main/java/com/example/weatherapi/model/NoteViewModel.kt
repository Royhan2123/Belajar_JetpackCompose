package com.example.weatherapi.model

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weatherapi.data.Note
import com.example.weatherapi.data.NoteSource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class NoteViewModel : ViewModel() {
    val notelist = mutableListOf<Note>()
    
    init {
        notelist.addAll(NoteSource().loadNotes())
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