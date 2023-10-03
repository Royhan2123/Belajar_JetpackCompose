package com.example.latihancompose.ui.Page

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.AttachFile
import androidx.compose.material.icons.filled.CalendarMonth
import androidx.compose.material.icons.filled.Dashboard
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Link
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Settings
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
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.latihancompose.ui.theme.Black
import com.example.latihancompose.ui.theme.White

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomePage(navController: NavController) {
    val dataMovie: List<String> = listOf("Royhan", "Reyhan", "Rizki")
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        "",
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                        style = TextStyle(
                            color = White
                        )
                    )
                },
                colors = TopAppBarDefaults.smallTopAppBarColors(
                    Color(0xFF090706)
                ),
                actions = {
                    IconButton(onClick = { }) {
                        Icon(
                            imageVector = Icons.Filled.AttachFile,
                            contentDescription = "Account",
                            modifier = Modifier.size(35.dp),
                            White
                        )
                    }
                    Spacer(
                        modifier = Modifier.padding(
                            start = 5.dp
                        )
                    )
                    IconButton(onClick = { }) {
                        Icon(
                            imageVector = Icons.Filled.CalendarMonth,
                            contentDescription = "Account",
                            modifier = Modifier.size(35.dp),
                            White
                        )
                    }
                    Spacer(
                        modifier = Modifier.padding(
                            end = 5.dp
                        )
                    )
                    IconButton(onClick = { }) {
                        Icon(
                            imageVector = Icons.Filled.MoreVert,
                            contentDescription = "Account",
                            modifier = Modifier.size(35.dp),
                            White
                        )
                    }
                },
                navigationIcon = {
                    IconButton(onClick = { }) {
                        Icon(
                            imageVector = Icons.Filled.Menu,
                            contentDescription = "Menu",
                            modifier = Modifier.size(35.dp),
                            White
                        )
                    }
                }
            )
        },
    ) {
        MainContent(navController = navController)
    }
}

@Composable
fun MainContent(navController: NavController) {
    val dataList: List<String> = listOf(
        "Harry potter",
        "Naruto",
        "Sasuke",
        "Orochimaru",
        "Itachi"
    )
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 60.dp),
        color = Color(0xFF090300)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 20.dp, top = 30.dp,
                    end = 20.dp)
        ) {
            Text(
                text = "Movie Fun",
                modifier = Modifier.padding(bottom = 20.dp),
                style = TextStyle(
                    color = White,
                    fontSize = 15.sp
                )
            )
            LazyRow(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
            ) {
                items(dataList) { item ->
                    CardMovie()
                }
            }
        }
    }
}

@Preview
@Composable
fun PreviewHomePage() {
    HomePage(navController = rememberNavController())
}


@Composable
fun CardMovie() {
    Surface(
        modifier = Modifier
            .width(150.dp)
            .height(170.dp)
            .padding(end = 15.dp),
        color = Color.White,
        shape = RoundedCornerShape(
            corner = CornerSize(20.dp),
        )
    ) {

    }
}