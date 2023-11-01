package com.example.latihanviewmodel.screen

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.latihanviewmodel.components.NotesScreen
import com.example.latihanviewmodel.model.NoteViewModel

@SuppressLint("UnrememberedMutableState")
@Composable
fun HomePage(
    navController: NavController
) {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        val noteViewModel:NoteViewModel = viewModel()
        NotesApp(noteViewModel = noteViewModel)
    }
}

@Composable
fun NotesApp(noteViewModel: NoteViewModel = viewModel()){
    val notes = noteViewModel.getAllNote()

    NotesScreen(
        notes = notes,
        onAddNote = {
            noteViewModel.removeNote(it)
        },
        onRemoveNote = {
            noteViewModel.addNote(it)
        }
    )
}


@Preview
@Composable
fun PreviewsHome() {
    HomePage(navController = rememberNavController())
}