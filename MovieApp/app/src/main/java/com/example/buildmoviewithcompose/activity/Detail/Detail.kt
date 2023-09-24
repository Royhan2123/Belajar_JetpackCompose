package com.example.buildmoviewithcompose.activity.Detail

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
import com.bawp.movieapp.model.Movie
import com.bawp.movieapp.model.getMovies
import com.example.buildmoviewithcompose.widgets.CardMovie

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailScreen(navController: NavController, movieId: String?) {
    val newMovieList = getMovies().filter {movie ->
        movie.id == movieId
    }
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Row(
                        horizontalArrangement = Arrangement.Start,
                        ) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "Arrow Backk",
                            modifier = Modifier.clickable {
                                navController.popBackStack()
                            },
                            tint = Color.Black)
                        Spacer(modifier = Modifier.width(100.dp))
                        Text(text = "Detail", style = TextStyle(
                            fontSize = 20.sp,
                            color = Color.Black
                        )
                        )
                    }
                }, colors = TopAppBarDefaults.largeTopAppBarColors(
                    Color.White
                )
            )
        }) {
        Surface (
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 50.dp),
            color = Color.White
        ) {
            Column (modifier = Modifier
                .fillMaxSize()
                .padding(20.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Top) {
                CardMovie(movie = newMovieList.first())
                Spacer(modifier = Modifier.height(10.dp))
                Divider()
                HorizontalScrolableImageView(newMovieList)
            }
        }
    }
}

@Composable
private fun HorizontalScrolableImageView(newMovieList: List<Movie>) {
    LazyRow {
        items(newMovieList[0].images) { image ->
            Card(
                modifier = Modifier
                    .padding(12.dp)
                    .size(200.dp),
                elevation = CardDefaults
                    .cardElevation(10.dp),
                colors = CardDefaults
                    .cardColors(Color.White),
                shape = RoundedCornerShape(
                    corner = CornerSize(12.dp)
                )
            ) {
                Image(
                    modifier = Modifier.size(200.dp),
                    contentScale = ContentScale.Crop,
                    painter = rememberImagePainter(data = image),
                    contentDescription = "Movie Poster"
                )
            }
        }
    }
}