package com.example.latihancompose.Widget

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsFocusedAsState
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Text
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TextFieldStyle(
    enabled: Boolean,
    modifier: Modifier,
    valueState: MutableState<String>,
    labelId: String,
    isSingleLine: Boolean,
    keyboardType: KeyboardType,
    imeAction: ImeAction = ImeAction.Next,
    onAction: KeyboardActions = KeyboardActions.Default,
    trailingIcon: @Composable ()-> Unit,
    visualTransformation: VisualTransformation
) {
    val interactionSource = remember { MutableInteractionSource() }
    val isFocused = interactionSource.collectIsFocusedAsState()

    OutlinedTextField(
        value = valueState.value,
        onValueChange =  {valueState.value = it},
        label = { Text(text = labelId, style = TextStyle(
            color = if (isFocused.value) Color.Blue
            else Color.Black
        )) },
        enabled = enabled,
        modifier = modifier
            .fillMaxWidth()
            .height(60.dp),
        singleLine = isSingleLine,
        textStyle = TextStyle(
            fontSize = 15.sp,
            color = Color.Black
        ),
        keyboardOptions = KeyboardOptions(keyboardType = keyboardType, imeAction = imeAction),
        keyboardActions = onAction,
        colors = TextFieldDefaults.textFieldColors(
            containerColor = Color.Transparent,
            textColor = Color.Black,
            cursorColor = Color.Black,
        ),
        shape = RoundedCornerShape(
            corner = CornerSize(
                15.dp
            )
        ),
        trailingIcon = trailingIcon,
        visualTransformation = visualTransformation
    )
}