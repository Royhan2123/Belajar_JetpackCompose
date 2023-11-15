package com.example.latihanparsingjson

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.latihanparsingjson.component.Questions
import com.example.latihanparsingjson.navigation.Navigations
import com.example.latihanparsingjson.ui.theme.LatihanParsingJsonTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApp {
                Navigations()
            }
        }
    }
}

@Composable
fun MyApp(content: @Composable () -> Unit) {
    LatihanParsingJsonTheme {
        content()
    }
}

@Preview
@Composable
fun PreviewsMyApp() {
    MyApp {
        Questions()
    }
}
