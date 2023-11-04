package com.example.latihanviewmodel.components

import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.latihanviewmodel.components.util.formatDate
import com.example.latihanviewmodel.data.NotesDataSource
import com.example.latihanviewmodel.data.Note

@Composable
fun NotesScreen(
    notes: List<Note>,
    onAddNote: (Note) -> Unit,
    onRemoveNote: (Note) -> Unit
) {
    var txtTitle by remember {
        mutableStateOf("")
    }
    var txtAddNote by remember {
        mutableStateOf("")
    }
    val context = LocalContext.current
    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .padding(20.dp)
                .fillMaxSize()
        ) {
            TextFieldStyle(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp),
                onValueState = {
                    if (it.all { char ->
                            char.isLetter() || char.isWhitespace()
                        }) txtTitle = it
                },
                label = "Add Note",
                placeHolder = "Input Your Note",
                text = txtTitle
            )
            TextFieldStyle(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp)
                    .offset(y = 10.dp),
                onValueState = {
                    if (it.all { char ->
                            char.isWhitespace() || char.isLetter()
                        }) txtAddNote = it
                },
                label = "Add Desc",
                placeHolder = "Input Your Desc",
                text = txtAddNote
            )
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(70.dp)
                    .offset(y = 10.dp),
                contentAlignment = Alignment.Center,
            ) {
                ButtonStyle(
                    modifier = Modifier
                        .width(150.dp)
                        .height(35.dp),
                    text = "Save",
                    onClick = {
                        if (
                            txtTitle.isNotEmpty() && txtAddNote.isNotEmpty()) {
                            onAddNote(
                                Note(
                                    title = txtTitle,
                                    description = txtAddNote
                                )
                            )
                            txtTitle = ""
                            txtAddNote = ""
                            Toast.makeText(
                                context, "Note Added",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    })
            }
            Divider(
                modifier = Modifier
                    .offset(y = 10.dp)
                    .height(3.dp)
            )
            Spacer(modifier = Modifier.padding(bottom = 25.dp))
            LazyColumn {
                items(notes) { note ->
                    NoteRow(
                        modifier = Modifier,
                        note = note,
                        onNoteClicked = {
                            onRemoveNote(note)
                        })
                }
            }
        }
    }
}

@Preview
@Composable
fun Previewss() {
    NotesScreen(
        notes = NotesDataSource().loadNotes(),
        onAddNote = {},
        onRemoveNote = {}
    )
}


@Composable
fun NoteRow(
    modifier: Modifier,
    note: Note,
    onNoteClicked: (Note) -> Unit,
) {
    Surface(
        modifier
            .padding(4.dp)
            .clip(
                RoundedCornerShape(
                    topEnd = 33.dp,
                    bottomStart = 33.dp
                )
            )
            .fillMaxWidth(),
        color = Color(0xFFDFE6EB),
        elevation = 6.dp
    ) {
        Column(
            modifier
                .clickable {
                    onNoteClicked(note)
                }
                .padding(horizontal = 14.dp, vertical = 6.dp),
            horizontalAlignment = Alignment.Start
        ) {
            Text(
                text = note.title,
                style = MaterialTheme.typography.subtitle2
            )
            Text(
                text = note.description,
                style = MaterialTheme.typography.subtitle1
            )
            Text(
                text = formatDate(note.entryDate.time),
                style = MaterialTheme.typography.caption
            )
        }
    }
}
