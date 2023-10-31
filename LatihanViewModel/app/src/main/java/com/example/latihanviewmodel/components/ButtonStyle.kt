package com.example.latihanviewmodel.components

import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.latihanviewmodel.ui.theme.Primary

@Composable
fun ButtonStyle(
    modifier: Modifier,
    text: String,
    onClick: () -> Unit,
    enabled: Boolean = true,
) {
    Button(
        onClick = onClick,
        shape = CircleShape,
        enabled = enabled,
        modifier = modifier,
        colors = ButtonDefaults.buttonColors(
            Primary
        )
    ) {
        Text(text = text, color = Color.White)
    }
}