package com.example.latihanviewmodel.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Divider
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.latihanviewmodel.model.Note

@Composable
fun NotesList(
    notes: List<Note>
) {
    var txtTitle by remember {
        mutableStateOf("")
    }
    var txtAddNote by remember {
        mutableStateOf("")
    }
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
                        if (txtTitle.isNotEmpty() && txtAddNote.isNotEmpty()){
                            // save/add to the list
                            txtTitle = ""
                            txtAddNote = ""
                        }
                    })
            }
            Divider(
                modifier = Modifier
                    .offset(y = 10.dp)
                    .height(3.dp)
            )
        }
    }
}