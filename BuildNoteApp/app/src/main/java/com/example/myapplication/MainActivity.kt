package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.myapplication.model.Note
import com.example.myapplication.model.NoteViewModel
import com.example.myapplication.screen.NoteScreen
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val noteViewModel: NoteViewModel by viewModels()
            NotesApp(
                noteViewModel
            )
        }
    }
}


@Composable
fun NotesApp(noteViewModel: NoteViewModel = viewModel()) {
    val noteList = noteViewModel.getAllNotes()
    NoteScreen(
        notes = noteList,
        onRemoveNote = {
            noteViewModel.removeNote(it)
        },
        onAddNote = {
            noteViewModel.addNote(it)
        },
    )
}

@Composable
fun MainContent(
    content: @Composable () -> Unit
) {
    MyApplicationTheme {
        NoteScreen(
            notes = emptyList(),
            onRemoveNote = {},
            onAddNote = {},
        )
    }
}

@Composable
@Preview
fun DefaultPreview() {
    MainContent {

    }
}