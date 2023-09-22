package com.example.buildmoviewithcompose.screen.Home

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AccountCircle
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.buildmoviewithcompose.navigation.MoviesScreens
import com.example.buildmoviewithcompose.ui.CardMovie
import com.example.buildmoviewithcompose.ui.theme.Cyan

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "My App", modifier = Modifier
                            .offset(x = 30.dp)
                    )
                },
                colors = TopAppBarDefaults.smallTopAppBarColors(
                    Cyan
                ),
                navigationIcon = {
                    Icon(
                        imageVector = Icons.Rounded.AccountCircle,
                        contentDescription = "account",
                        modifier = Modifier
                            .offset(x = 10.dp)
                            .size(35.dp)
                    )
                }
            )
        },
    ) {
        MainContent(navController = navController)
    }
}

@Composable
fun MainContent(
    navController: NavController,
    datalist: List<String> = listOf(
        "Royhan",
        "Reyhan",
        "Rizki",
        "Rayhan",
        "Rozak",
        "Rozak",
        "Rozak",
        "Rozak",
        "Rozak",
        "Rozak",
        "Rozak",
    )
) {
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 50.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(
                    vertical = 20.dp,
                    horizontal = 10.dp
                )
        ) {
            LazyColumn {
                items(items = datalist){
                    CardMovie(movie = it){movie ->
                        navController.navigate(MoviesScreens.DetailScreen.name + "/$movie")
                    }
                }
            }
        }
    }
}