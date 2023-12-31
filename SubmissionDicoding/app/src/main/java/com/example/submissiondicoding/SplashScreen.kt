package com.example.submissiondicoding

import android.window.SplashScreen
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.submissiondicoding.navigation.NavigationScreen
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(
    navController: NavController
) {
    LaunchedEffect(key1 = true,){
        delay(
            3000L,
        )
        navController.graph.startDestinationRoute?.let {
            navController.popBackStack(
                route = it,
                inclusive = true
            )
        }
        navController.navigate(NavigationScreen.Home.name)
    }
    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
        ) {
            Surface(
                modifier = Modifier.size(120.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.splash),
                    contentDescription = "splash"
                )
            }
        }
    }
}

@Preview
@Composable
fun PreviewSplash() {
    SplashScreen(
        navController = rememberNavController()
    )
}