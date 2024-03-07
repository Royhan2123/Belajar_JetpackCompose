package com.example.newapplicationjetpackcompose.ui.page.Homepages

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun NavigationCupcakes(navController: NavController){

}

@Preview (showSystemUi = true)
@Composable
fun PreviewNavigationCupcakes(){
    NavigationCupcakes(navController = rememberNavController())
}
