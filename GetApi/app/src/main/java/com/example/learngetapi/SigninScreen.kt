package com.example.learngetapi

import androidx.compose.material3.OutlinedTextField
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun SignInScreen(
    navController: NavController,
) {
    val txtEmail by rememberSaveable {
        mutableStateOf("")
    }

    Column (
        modifier = Modifier.fillMaxSize()
    ) {
    }
}

@Preview(showSystemUi = true)
@Composable
fun PreviewSigninScreen() {
    SignInScreen(navController = rememberNavController())
}
