package com.example.latihancompose.ui.Page

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Dashboard
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.latihancompose.ui.theme.Black
import com.example.latihancompose.ui.theme.White

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomePage(navController: NavController){
    val dataMovie:List<String> = listOf("Royhan","Reyhan","Rizki")
    Scaffold (
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        "My App",
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                },
                colors = TopAppBarDefaults.smallTopAppBarColors(
                    White,
                ),
                actions = {
                    IconButton(onClick = { }) {
                        Icon(
                            imageVector = Icons.Filled.AccountCircle,
                            contentDescription = "Account",
                            modifier = Modifier.size(35.dp)
                        )
                    }
                }
            )
        },
    ){
        MainContent(navController = navController)
    }
}

@Composable
fun MainContent(navController: NavController){
    Surface (
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 60.dp),
        color = Black
    ){
        Column (
            modifier = Modifier.fillMaxSize()
                .padding(20.dp)
        ) {
            Text(text = "Hello", style = TextStyle(
                color = White
            ))
        }
    }
}
@Preview
@Composable
fun PreviewHomePage(){
    HomePage(navController = rememberNavController())
}


@Composable
fun CardMovie(){
    Surface (
        modifier = Modifier
            .fillMaxWidth()
            .height(120.dp),
        color = Color.White
    ) {
        Row (modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)){
            Surface (
                modifier = Modifier.size(75.dp),
                shape = CircleShape,
                color = Color.Gray
            ) {

            }
        }
    }
}
@Preview
@Composable
fun PreviewCarrd(){
    CardMovie()
}