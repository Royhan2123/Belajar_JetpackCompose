package com.example.weatherapi

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.weatherapi.navigation.NavigationScreen
import com.example.weatherapi.ui.theme.Orange

@Composable
fun SplashScreen2(navController: NavController) {
    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        Box(modifier = Modifier.fillMaxSize()) {
            Image(
                painter = painterResource(id = R.drawable.splashsreen2),
                contentDescription = "splash-screen2",
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )
            Column(
                modifier = Modifier
                    .padding(20.dp)
                    .offset(y = 250.dp),
            ) {
                Text(
                    text = "Welcome to the Hotel App",
                    color = Color.White, style = TextStyle(
                        fontSize = 22.sp,
                        fontWeight = FontWeight.Bold
                    )
                )
                Text(
                    text = "A place where comfort and convenience\nMeet To ensure your stay is extraordinary \nWith a userInterface Hotel App takes\nYou into a world of personalized services.",
                    color = Color.Gray, style = TextStyle(
                        fontSize = 17.sp,
                    ), textAlign = TextAlign.Justify
                )
            }
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(bottom = 20.dp),
                contentAlignment = Alignment.BottomCenter
            ) {
                Button(
                    onClick = {
                        navController.navigate(
                            NavigationScreen.HalamanBottom.name
                        )
                    },
                    modifier = Modifier
                        .width(300.dp)
                        .height(37.dp),
                    shape = RoundedCornerShape(
                        corner = CornerSize(15.dp)
                    ),
                    colors = ButtonDefaults.buttonColors(
                        Orange
                    )
                ) {
                    Text(
                        text = "Get Started",
                        fontSize = 15.sp
                    )
                }
            }
        }
    }
}


@Preview
@Composable
fun Preciewss() {
    SplashScreen2(navController = rememberNavController())
}