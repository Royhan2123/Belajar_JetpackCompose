package com.example.submissiondicoding

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
import com.example.submissiondicoding.navigation.Navigations
import com.example.submissiondicoding.ui.theme.SubmissionDicodingTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainContent {
                Navigations()
            }
        }
    }
}

@Composable
fun MainContent(content:@Composable () -> Unit){
    SubmissionDicodingTheme {
        content()
    }
}

@Preview
@Composable
fun Previews(){
    MainContent {
        Navigations()
    }
}