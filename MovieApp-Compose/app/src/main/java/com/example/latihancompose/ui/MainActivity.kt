package com.example.latihancompose.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.latihancompose.ui.theme.LatihanComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MovieApp {

            }
        }
    }
}

@Preview
@Composable
fun Preview(){
    MovieApp {

    }
}

@Composable
fun MovieApp(content: @Composable ()-> Unit) {
    LatihanComposeTheme {
        content()
    }
}
