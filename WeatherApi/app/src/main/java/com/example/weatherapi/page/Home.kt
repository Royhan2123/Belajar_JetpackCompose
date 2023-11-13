package com.example.weatherapi.page

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.weatherapi.components.NoteScreen
import com.example.weatherapi.data.Note
import com.example.weatherapi.model.NoteViewModel

@Composable
fun Home(navController: NavController) {
    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp),
        ) {
            NotesApp()
        }
    }
}

@Composable
fun NotesApp(noteViewModel: NoteViewModel = viewModel()){
    val notelist = noteViewModel.getAllNotes()
    NoteScreen(
        notes = notelist,
        addNote = { noteViewModel.addNote(it) },
        removeNote = {noteViewModel.removeNote(it)})
}


@Preview
@Composable
fun PreviewsHome() {
    Home(navController = rememberNavController())
}