package com.example.jetpackcomposeapi.page

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun SignUpSetPin(navController: NavController) {
    Column (
        modifier = Modifier.fillMaxSize()
    ) {

    }
}

@Preview
@Composable
fun PreviewSignUpSetPin() {
    SignUpSetPin(
        navController = rememberNavController()
    )
}