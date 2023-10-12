package com.example.latihancompose.ui.Page

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.latihancompose.R
import com.example.latihancompose.ui.theme.Black
import com.example.latihancompose.ui.theme.White

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Account(navController: NavController) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = "Account",
                        style = TextStyle(
                            fontSize = 17.sp,
                            color = White
                        )
                    )
                },
                colors = TopAppBarDefaults.smallTopAppBarColors(
                    Color(0xFF0F0602)
                ),
                navigationIcon = {
                    IconButton(onClick = {
                        navController.popBackStack()
                    }) {
                        Icon(
                            imageVector = Icons.Rounded.ArrowBack,
                            contentDescription = "Back",
                            tint = White,
                            modifier = Modifier.size(25.dp)
                        )
                    }
                }
            )
        }
    ) {
        AccountContent()
    }
}

@Composable
fun AccountContent() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color(0xFF0F0602)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
        ) {
            Surface(
                modifier = Modifier.size(120.dp),
                shape = CircleShape
            ) {
                Image(
                    painter = painterResource(id = R.drawable.royhan),
                    contentDescription = "royhan",
                    contentScale = ContentScale.Crop
                )
            }
            Text(
                text = "Royhan",
                style = TextStyle(fontSize = 17.sp, color = White),
                modifier = Modifier.padding(top = 20.dp)
            )
            Text(
                text = "royhankeren12@gmail.com",
                style = TextStyle(fontSize = 17.sp, color = White),
                modifier = Modifier.padding(top = 10.dp)
            )
        }
    }
}

@Preview
@Composable
fun PreviewAccount() {
    Account(navController = rememberNavController())
}