package com.example.latihanviewmodel.components

import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class, ExperimentalComposeUiApi::class)
@Composable
fun TextFieldStyle(
    modifier:Modifier,
    imeAction: () -> Unit = {},
    onValueState:(String) -> Unit,
    label:String,
    placeHolder:String,
    text:String,
    maxline:Int = 1,
) {
    val keyboardController = LocalSoftwareKeyboardController.current
    OutlinedTextField(
        value = text,
        onValueChange = onValueState,
        colors = TextFieldDefaults.textFieldColors(
            containerColor = Color.Transparent,
        ),
        maxLines = maxline,
        label = { Text(text = label)},
        keyboardOptions = KeyboardOptions.Default.copy(
            imeAction = ImeAction.Done,
        ),
        keyboardActions = KeyboardActions(onDone = {
            imeAction()
            keyboardController?.hide()
        }),
        modifier = modifier,
        placeholder = {
            Text(text = placeHolder, color = Color.Gray, fontSize = 13.sp)
        },
        shape = RoundedCornerShape(
            corner = CornerSize(15.dp)
        )
    )
}

