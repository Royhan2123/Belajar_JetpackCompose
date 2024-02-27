package com.example.newapplicationjetpackcompose.ui.page


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun HomePage(navController: NavController){
    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        horizontalAlignment = Alignment.Start,
    ) {

    }
}


@Composable
fun CardHomePage(){
    Card (
        modifier = Modifier.fillMaxWidth()
            .height(120.dp),
        elevation = 8.dp,
        shape = RoundedCornerShape(
            12.dp
        ),
    ) {
        
    }
}


@Preview
@Composable
fun CardHomePagePreview(){
    CardHomePage()
}

@Preview(showSystemUi = true)
@Composable
fun PreviewHomePage(){
    HomePage(navController = rememberNavController())
}