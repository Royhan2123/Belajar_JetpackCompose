package com.example.newapplicationjetpackcompose.widget

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TextFieldStyle() {
    var txtGmail by remember {
        mutableStateOf("")
    }
    TextField(value = txtGmail, onValueChange = { txtGmail = it })
}