package com.example.latihanviewmodel.model

import android.util.Log
import com.example.latihanviewmodel.data.Note
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.latihanviewmodel.repository.NoteRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class NoteViewModel @Inject constructor(private val repository: NoteRepository) : ViewModel() {
    private val _notelist = MutableStateFlow<List<Note>>(emptyList())
    val notelist = _notelist.asStateFlow()

    init {
        viewModelScope.launch(Dispatchers.IO) {
            repository.getAllNotes().distinctUntilChanged().collect { listOfNote ->
                if (listOfNote.isEmpty()) {
                    Log.d("Empty", ": Empty list")
                } else {
                    _notelist.value = listOfNote
                }
            }
        }
    }

    fun addNote(note: Note) = viewModelScope.launch { repository.addNote(note) }
    fun updateNote(note: Note) = viewModelScope.launch { repository.updateNote(note) }
    fun deleteNote(note: Note) = viewModelScope.launch { repository.deleteNote(note) }
}