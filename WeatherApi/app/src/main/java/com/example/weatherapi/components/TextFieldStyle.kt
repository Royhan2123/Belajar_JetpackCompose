package com.example.weatherapi.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class, ExperimentalComposeUiApi::class)
@Composable
fun TextFieldStyle(
    enabled: Boolean,
    maxLine: Int = 1,
    onValueState: (String) -> Unit,
    text: String,
    placeHolder: String,
    imeAction: () -> Unit = {},
    label: String
) {

    val keyboardController = LocalSoftwareKeyboardController.current
    OutlinedTextField(
        value = text,
        onValueChange = onValueState,
        enabled = enabled,
        modifier = Modifier
            .fillMaxWidth()
            .height(65.dp),
        maxLines = maxLine,
        placeholder = { Text(text = placeHolder, color = Color.Gray, fontSize = 15.sp) },
        keyboardActions = KeyboardActions(onDone = {
            imeAction()
            keyboardController?.hide()
        }),
        keyboardOptions = KeyboardOptions.Default.copy(
            imeAction = ImeAction.Done
        ),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            containerColor = Color.Transparent,
            cursorColor = Color.Black

        ),
        textStyle = TextStyle(
            color = Color.Black,
            fontSize = 14.sp,
        ),
        label = {
            Text(
                text = label, color =
                Color.Black
            )
        }
    )
}