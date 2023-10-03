package com.example.latihancompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.latihancompose.ui.IniNavigation
import com.example.latihancompose.ui.theme.LatihanComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MovieApp {
                IniNavigation()
            }
        }
    }
}

@Preview
@Composable
fun Preview(){
    MovieApp {
        IniNavigation()
    }
}

@Composable
fun MovieApp(content: @Composable ()-> Unit) {
    LatihanComposeTheme {
        content()
    }
}
