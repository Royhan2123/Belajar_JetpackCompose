package com.example.latihancompose

import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material.Text
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TextFieldStyle(
    enabled: Boolean,
    modifier: Modifier,
    valueState: MutableState<String>,
    labelId: String,
    isSingleLine: Boolean,
    keyboardType: KeyboardType = KeyboardType.Email,
    imeAction: ImeAction = ImeAction.Next,
    onAction: KeyboardActions = KeyboardActions.Default
) {
    TextField(
        value = valueState.value,
        onValueChange =  {valueState.value = it},
        label = { Text(text = labelId) },
        enabled = enabled,
        modifier = modifier,
        singleLine = isSingleLine,

    )
}