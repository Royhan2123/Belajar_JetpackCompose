package com.example.weatherapi

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
import com.example.weatherapi.navigation.Navigations
import com.example.weatherapi.ui.theme.WeatherApiTheme
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.HiltAndroidApp


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
fun MyApp(content:@Composable ()-> Unit) {
    WeatherApiTheme {
        Navigations()
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyApp {

    }
}