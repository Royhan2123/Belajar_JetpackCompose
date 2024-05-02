package com.example.jetpackcomposeapi

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.jetpackcomposeapi.navigation.Navigations
import com.example.jetpackcomposeapi.ui.theme.JetpackComposeApiTheme
import com.example.jetpackcomposeapi.widget.CardDestination
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeApiTheme {
            Navigations()
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun Previews(){
    Navigations()
}