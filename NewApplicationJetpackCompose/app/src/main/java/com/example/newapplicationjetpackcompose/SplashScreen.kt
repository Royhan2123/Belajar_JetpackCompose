package com.example.newapplicationjetpackcompose

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.newapplicationjetpackcompose.navigation.NavigationScreen
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavController){

    LaunchedEffect(key1 = true,){
        delay(5000L)
        navController.graph.startDestinationRoute?.let {
            navController.popBackStack(
                route = it,
                inclusive = true
            )
        }
        navController.navigate(NavigationScreen.HomePage.name)
    }
    Column (
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(painter = painterResource(id = R.drawable.logo_splash),
            contentDescription = "splash-screen",
            modifier = Modifier.size(125.dp))
    }
}

@Preview(showSystemUi = true)
@Composable
fun PreviewSplashScreen(){
    SplashScreen(navController = rememberNavController())
}