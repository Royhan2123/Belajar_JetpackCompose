package com.example.myapplication.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Notifications
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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplication.R
import com.example.myapplication.components.NoteButton
import com.example.myapplication.components.NoteInputText
import com.example.myapplication.model.Note
import com.example.myapplication.ui.theme.White

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NoteScreen(
    notes:List<Note>,
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
                horizontalAlignment = Alignment.CenterHorizontally,
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
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun NotePreview() {
    NoteScreen(
        notes = emptyList(),
        onAddNote = {},
        onRemoveNote = {},
    )
}