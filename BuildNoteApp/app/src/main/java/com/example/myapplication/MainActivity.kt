package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview
import com.example.myapplication.data.NotesDataSource
import com.example.myapplication.model.Note
import com.example.myapplication.screen.NoteScreen
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val notes = remember {
                mutableStateListOf<Note>()
            }
            NoteScreen(
                notes = notes,
                onRemoveNote = {
                               notes.remove(it)
                },
                onAddNote = {
                    notes.add(it)
                },
            )
        }
    }
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