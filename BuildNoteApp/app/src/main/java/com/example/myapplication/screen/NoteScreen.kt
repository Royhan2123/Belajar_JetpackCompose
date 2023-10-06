package com.example.myapplication.screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Notifications
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.R
import com.example.myapplication.components.NoteButton
import com.example.myapplication.components.NoteInputText
import com.example.myapplication.data.NotesDataSource
import com.example.myapplication.model.Note
import com.example.myapplication.ui.theme.Black
import com.example.myapplication.ui.theme.White
import java.time.format.DateTimeFormatter

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NoteScreen(
    notes: List<Note>,
    onAddNote: (Note) -> Unit,
    onRemoveNote: (Note) -> Unit,
) {
    var title by remember {
        mutableStateOf("")
    }
    var description by remember {
        mutableStateOf("")
    }
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = White
    ) {
        Column(
            modifier = Modifier
                .padding(6.dp)
                .fillMaxSize()
        ) {
            TopAppBar(
                title = {
                    Text(text = stringResource(id = R.string.app_name))
                },
                actions = {
                    Icon(
                        imageVector = Icons.Rounded.Notifications,
                        contentDescription = "Notification",
                        modifier = Modifier.size(30.dp)
                    )
                },
                colors = TopAppBarDefaults.smallTopAppBarColors(
                    containerColor = androidx.compose.ui.graphics.Color.White
                ),
            )
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(15.dp),
                horizontalAlignment = Alignment.Start,
            ) {
                NoteInputText(
                    text = title,
                    modifier = Modifier
                        .padding(
                            top = 10.dp, bottom = 10.dp
                        )
                        .fillMaxWidth(),
                    label = "Title",
                    onTextChange = {
                        if (it.all { char ->
                                char.isLetter() || char.isWhitespace()
                            }) title = it
                    }
                )
                NoteInputText(
                    text = description,
                    label = "Add a Note",
                    modifier = Modifier
                        .padding(
                            top = 10.dp, bottom = 20.dp
                        )
                        .fillMaxWidth(),
                    onTextChange = {
                        if (it.all { char ->
                                char.isLetter() || char.isWhitespace()
                            }) description = it
                    }
                )
                NoteButton(
                    text = "Save", onClick = {
                        if (title.isNotEmpty() && description.isNotEmpty()) {
                            title = ""
                            description = ""

                        }
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(40.dp)
                )
                Divider(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(2.dp)
                        .offset(y = 15.dp),
                    color = Color.Gray,
                    thickness = 5.dp
                )
                LazyColumn(
                    modifier = Modifier.padding(top = 50.dp)
                ) {
                    items(notes) { note ->
                       NoteRow(note = note, onNoteClick = {})
                    }
                }
            }
        }
    }
}

@Composable
fun NoteRow(
    modifier: Modifier = Modifier,
    note: Note,
    onNoteClick: (Note) -> Unit,
) {
    Surface(
        modifier
            .padding(4.dp)
            .clip(RoundedCornerShape(topEnd = 33.dp, bottomStart = 33.dp))
            .fillMaxWidth(),
        color = Color(0xFFDFE6EB),
        shadowElevation = 6.dp
    ) {
        Column(
            modifier
                .clickable {

                }
                .padding(horizontal = 14.dp, vertical = 10.dp),
            horizontalAlignment = Alignment.Start
        ) {
            Text(
                text = note.title, style = TextStyle(
                    fontSize = 13.sp,
                    color = Black
                )
            )
            Text(
                text = note.description, style = TextStyle(
                    fontSize = 13.sp,
                    color = Black

                )
            )
            Text(
                text = note.entryDate.format(
                    DateTimeFormatter.ofPattern("EEE,d MMM")
                ), style = TextStyle(
                    fontSize = 13.sp,
                    color = Black

                )
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun NotePreview() {
    NoteScreen(
        notes = NotesDataSource().loadNotes(),
        onAddNote = {},
        onRemoveNote = {},
    )
}