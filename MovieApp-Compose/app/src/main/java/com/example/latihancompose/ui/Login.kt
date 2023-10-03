package com.example.latihancompose.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun Login(navController: NavController) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color.White,
    ) {
        Card(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp)
                .background(color = Color.White),
            elevation = 20.dp,
            shape = RoundedCornerShape(
                corner = CornerSize(20.dp)
            ),
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(10.dp),
            ) {
                Box (modifier = Modifier.fillMaxWidth(),
                    contentAlignment = Alignment.Center){
                    Text(text = "Login Your Account",
                        style = TextStyle(
                            fontSize = 20.sp,
                            color = Color.Black,
                            fontFamily = FontFamily.SansSerif,
                        ),
                    )
                }
                Spacer(modifier = Modifier.offset(y = 100.dp))

            }
        }
    }
}

@Preview
@Composable
fun PreviewLogin() {
    Login(navController = rememberNavController())
}