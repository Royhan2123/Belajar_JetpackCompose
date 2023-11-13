package com.example.weatherapi.components

import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults.buttonColors
import androidx.compose.material.Surface
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.weatherapi.data.Note
import com.example.weatherapi.data.NoteSource


@Composable
fun NoteScreen(
    notes: List<Note>,
    addNote: (Note) -> Unit,
    removeNote: (Note) -> Unit

) {
    var title by remember {
        mutableStateOf("")
    }
    var desc by remember {
        mutableStateOf("")
    }
    val context = LocalContext.current
    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp)
        ) {
            TextFieldStyle(
                enabled = true,
                onValueState = {
                    if (it.all { char ->
                            char.isLetter() || char.isWhitespace()
                        }) title = it
                },
                text = title,
                placeHolder = "Masukkan Data Note mu",
                label = "Note"
            )
            Spacer(modifier = Modifier.padding(bottom = 10.dp))
            TextFieldStyle(
                enabled = true,
                onValueState = {
                    if (it.all { char ->
                            char.isWhitespace() || char.isLetter()
                        }) desc = it
                },
                text = desc,
                placeHolder = "Masukkan Data Desc Mu",
                label = "Desc"
            )
            Spacer(modifier = Modifier.padding(bottom = 25.dp))
            Box(
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {
                Button(
                    onClick = {
                        if (title.isNotEmpty() && desc.isNotEmpty()) {
                            addNote(
                                Note(
                                    title = title, description = desc
                                )
                            )
                            title = ""
                            desc = ""
                            Toast.makeText(context,"Note Added",Toast.LENGTH_SHORT).show()
                        }
                    },
                    modifier = Modifier
                        .width(300.dp)
                        .height(35.dp),
                    colors = buttonColors(
                        Color.Blue

                    )
                ) {
                    Text(text = "Add Note")
                }
            }
            Divider(
                modifier = Modifier
                    .padding(top = 20.dp, bottom = 20.dp)
                    .height(1.dp)
                    .fillMaxWidth(),
                color = Color.LightGray
            )
            LazyColumn {
                items(notes) { note ->
                    CardRow(note = note, onNoteClick = {
                        removeNote(note)
                    })
                }
            }
        }
    }
}

@Composable
fun CardRow(
    note: Note,
    onNoteClick: (Note) -> Unit
) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .height(80.dp)
            .clip(
                RoundedCornerShape(
                    topEnd = 33.dp,
                    bottomStart = 33.dp
                )
            )
            .padding(4.dp),
        color = Color.LightGray
    ) {
        Column(
            modifier = Modifier
                .clickable {
                    onNoteClick(note)
                }
                .padding(horizontal = 14.dp, vertical = 10.dp),
            horizontalAlignment = Alignment.Start
        ) {
            Text(
                text = note.title,
                style = TextStyle(
                    fontSize = 13.sp,
                    color = Black
                )
            )
            Text(
                text = note.description,
                style = TextStyle(
                    fontSize = 13.sp,
                    color = Black
                )
            )
            Text(
                text = formatDate(note.entryDate.time),
                style = TextStyle(
                    fontSize = 13.sp,
                    color = Black
                )
            )
        }
    }
}

@Preview
@Composable
fun Previes() {
    NoteScreen(
        notes = NoteSource().loadNotes(),
        addNote = {},
        removeNote = {}
    )
}