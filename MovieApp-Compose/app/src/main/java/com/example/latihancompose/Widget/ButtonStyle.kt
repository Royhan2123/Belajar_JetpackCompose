package com.example.latihancompose.Widget

import android.service.autofill.OnClickAction
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.latihancompose.ui.theme.Primary
import com.example.latihancompose.ui.theme.White

@Composable
fun ButtonStyle(
    txt:String,
    onItemClick: () -> Unit,
    modifier:Modifier,
    enabled:Boolean,
){
    ElevatedButton(onClick = {
        onItemClick()
    },
        modifier = modifier
            .fillMaxWidth()
            .height(45.dp),
        enabled = enabled,
        shape = CircleShape,
        colors = ButtonDefaults.elevatedButtonColors(
            Primary
        )
    ) {
        Text(text = txt, style = TextStyle(
            color = White,
            fontSize = 13.sp
        ))
    }
}