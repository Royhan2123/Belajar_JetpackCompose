package com.example.newapplicationjetpackcompose

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.example.newapplicationjetpackcompose.navigation.NavigationScreen
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavController) {

    val lottieComposition by rememberLottieComposition(
        LottieCompositionSpec.RawRes(
            R.raw.splash_jastipin
        )
    )

    val progress by animateLottieCompositionAsState(
        composition = lottieComposition,
        iterations = LottieConstants.IterateForever,
        isPlaying = true
    )

    LaunchedEffect(key1 = true) {
        delay(5000L)
        navController.graph.startDestinationRoute?.let {
            navController.popBackStack(
                route = it,
                inclusive = true
            )
        }
        navController.navigate(NavigationScreen.SignInPage.name)
    }
    Column(
        modifier = Modifier.fillMaxSize()
            .background(
                color = Color.White
            ),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        LottieAnimation(
            composition = lottieComposition,
            progress = progress,
            modifier = Modifier.size(300.dp)
        )
    }
}

@Preview(showSystemUi = true)
@Composable
fun PreviewSplashScreen() {
    SplashScreen(navController = rememberNavController())
}