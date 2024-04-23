package com.example.learngetapi

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.example.learngetapi.navigation.Navigations
import com.example.learngetapi.presentation.onboarding.OnBoardingScreen
import com.example.learngetapi.presentation.onboarding.components.OnBoardingPage
import com.example.learngetapi.presentation.onboarding.pages
import com.example.learngetapi.ui.theme.LearnGetApiTheme
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.HiltAndroidApp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        setContent {
            LearnGetApiTheme {
              OnBoardingScreen()
            }
        }
    }
}
