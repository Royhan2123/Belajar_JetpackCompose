package com.example.myapplication

import android.graphics.Color
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.myapplication.screen.NoteScreen
import com.example.myapplication.ui.theme.MyApplicationTheme
import com.example.myapplication.ui.theme.White

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NoteScreen(
                notes = emptyList(),
                onRemoveNote = {},
                onAddNote = {},
            )
        }
    }
}

@Composable
fun MainContent(
    content: @Composable () -> Unit
) {
    MyApplicationTheme {
        NoteScreen(
            notes = emptyList(),
            onRemoveNote = {},
            onAddNote = {},
        )
    }
}

@Composable
@Preview
fun DefaultPreview() {
    MainContent {

    }
}