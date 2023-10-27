package com.example.latihanviewmodel.components

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsFocusedAsState
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
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
    modifier: Modifier,
    onValueState: MutableState<String>,
    enabled: Boolean,
    onAction: KeyboardActions = KeyboardActions.Default,
    imeAction: ImeAction = ImeAction.Next,
    trailingIcon: @Composable () -> Unit,
    visualTransformation: VisualTransformation,
    isSingleLine: Boolean,
    label: String,
    keyboardType: KeyboardType
) {
    val interactionSource = remember { MutableInteractionSource() }
    val isFocused = interactionSource.collectIsFocusedAsState()

    OutlinedTextField(
        value = onValueState.value,
        onValueChange = { onValueState.value = it },
        shape = RoundedCornerShape(corner = CornerSize(12.dp)),
        modifier = modifier,
        enabled = enabled,
        label = {
            Text(
                text = label,
                style = TextStyle(
                    color = if (isFocused.value) Color.Blue
                    else Color.Black
                )
            )
        },
        keyboardActions = onAction,
        keyboardOptions = KeyboardOptions(keyboardType = keyboardType, imeAction = imeAction),
        singleLine = isSingleLine,
        trailingIcon = trailingIcon,
        visualTransformation = visualTransformation,
        colors = TextFieldDefaults.textFieldColors(
            containerColor = Color.Transparent,
            cursorColor = Color.Black,
            textColor = Color.Black,
        ),
        textStyle = TextStyle(
            fontSize = 15.sp,
            color = Color.Black
        )
    )
}

