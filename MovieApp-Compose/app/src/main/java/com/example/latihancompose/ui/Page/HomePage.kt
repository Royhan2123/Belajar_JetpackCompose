package com.example.latihancompose.ui.Page

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AttachFile
import androidx.compose.material.icons.filled.CalendarMonth
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.rememberImagePainter
import com.example.latihancompose.ui.model.Movie
import com.example.latihancompose.ui.model.getMovies
import com.example.latihancompose.ui.model.getMoviesAventure
import com.example.latihancompose.ui.model.getMoviesHorror
import com.example.latihancompose.ui.theme.White

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomePage(navController: NavController) {
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
                    Color(0xFF1B0B03)
                ),
                actions = {
                    IconButton(onClick = { }) {
                        Icon(
                            imageVector = Icons.Filled.AttachFile,
                            contentDescription = "Account",
                            modifier = Modifier.size(35.dp),
                            Color(0xFFD3D2D2)
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
                            Color(0xFFD3D2D2)
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
                            Color(0xFFD3D2D2)
                        )
                    }
                },
                navigationIcon = {
                    IconButton(onClick = { }) {
                        Icon(
                            imageVector = Icons.Filled.Menu,
                            contentDescription = "Menu",
                            modifier = Modifier.size(35.dp),
                            Color(0xFFD3D2D2)
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
    val dataList: List<Movie> = getMovies()
    val dataMovieHorror: List<Movie> = getMoviesHorror()
    val dataMovieAdventure: List<Movie> = getMoviesAventure()
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 60.dp),
        color = Color(0xFF1B0B03)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(
                    start = 20.dp, top = 30.dp,
                    end = 20.dp
                )
        ) {
            Text(
                text = "Movie Action",
                modifier = Modifier.padding(bottom = 20.dp),
                style = TextStyle(
                    color = White,
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold
                )
            )
            LazyRow {
                items(items = dataList){
                    CardMovie(movie = it)
                }
            }
            Text(
                text = "Movie Horror",
                modifier = Modifier.padding(top = 35.dp,
                    bottom = 20.dp),
                style = TextStyle(
                    color = White,
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold

                )
            )
            LazyRow {
                items(items = dataMovieHorror){
                CardMovieHorror(movie = it)
                }
            }
            Text(
                text = "Movie Adventure",
                modifier = Modifier.padding(top = 35.dp,
                    bottom = 20.dp),
                style = TextStyle(
                    color = White,
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold

                )
            )
            LazyRow {
                items(items = dataMovieAdventure){
                    CardMovieAdventure(movie = it)
                }
            }
            Spacer(modifier = Modifier
                .padding(top = 50.dp))
        }
    }
}

@Preview
@Composable
fun PreviewHomePage() {
    HomePage(navController = rememberNavController())
}


@Composable
fun CardMovie(
    movie: Movie = getMovies()[0],
    onItemClick: @Composable ()-> Unit = {}
) {
    Column (
        modifier = Modifier
            .height(200.dp),
        horizontalAlignment = Alignment.Start,
    ) {
        Card (modifier = Modifier
            .width(150.dp)
            .height(170.dp)
            .padding(end = 15.dp),
            colors = CardDefaults.cardColors(
                Color.White
            ),
            shape = RoundedCornerShape(
                corner = CornerSize(20.dp),
            ),
            elevation = CardDefaults.cardElevation(
                10.dp
            )
        ) {
            Surface (
                modifier = Modifier.fillMaxSize()
            ) {
                Image(painter = rememberImagePainter(
                    data = movie.images[1],
                ),
                    contentScale = ContentScale.Crop,
                    contentDescription = "")
            }
        }
        Text(text = movie.title,
            style = TextStyle(
                fontSize = 17.sp,
                color = White
            ), modifier = Modifier.padding(top = 10.dp)
            )
    }
}

@Composable
fun CardMovieHorror(
    movie: Movie = getMoviesHorror()[0],
    onItemClick: @Composable ()-> Unit = {}
) {
    Column (
        modifier = Modifier
            .height(200.dp),
        horizontalAlignment = Alignment.Start,
    ) {
        Card (modifier = Modifier
            .width(150.dp)
            .height(170.dp)
            .padding(end = 15.dp),
            colors = CardDefaults.cardColors(
                Color.White
            ),
            shape = RoundedCornerShape(
                corner = CornerSize(20.dp),
            ),
            elevation = CardDefaults.cardElevation(
                10.dp
            )
        ) {
            Surface (
                modifier = Modifier.fillMaxSize()
            ) {
                Image(painter = rememberImagePainter(
                    data = movie.poster,
                ),
                    contentScale = ContentScale.Crop,
                    contentDescription = "")
            }
        }
        Text(text = movie.title,
            style = TextStyle(
                fontSize = 17.sp,
                color = White
            ), modifier = Modifier.padding(top = 10.dp)
        )
    }
}

@Composable
fun CardMovieAdventure(
    movie: Movie = getMoviesAventure()[0],
    onItemClick: @Composable ()-> Unit = {}
) {
    Column (
        modifier = Modifier
            .height(200.dp),
        horizontalAlignment = Alignment.Start,
    ) {
        Card (modifier = Modifier
            .width(150.dp)
            .height(170.dp)
            .padding(end = 15.dp),
            colors = CardDefaults.cardColors(
                Color.White
            ),
            shape = RoundedCornerShape(
                corner = CornerSize(20.dp),
            ),
            elevation = CardDefaults.cardElevation(
                10.dp
            )
        ) {
            Surface (
                modifier = Modifier.fillMaxSize()
            ) {
                Image(painter = rememberImagePainter(
                    data = movie.poster,
                ),
                    contentScale = ContentScale.Crop,
                    contentDescription = "")
            }
        }
        Text(text = movie.title,
            style = TextStyle(
                fontSize = 17.sp,
                color = White
            ), modifier = Modifier.padding(top = 10.dp)
        )
    }
}