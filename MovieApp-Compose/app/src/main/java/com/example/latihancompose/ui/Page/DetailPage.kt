package com.example.latihancompose.ui.Page

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.latihancompose.ui.model.Movie
import com.example.latihancompose.ui.model.getMovies

@Composable
fun DetailPage(
    navController: NavController,
    movieId: String?,
) {
    val newMovieList = getMovies().filter { movie ->
        movie.id == movieId
    }
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color.White,
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.Start,
        ) {
            Surface(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp),
                color = Color.Black,
                shape = RoundedCornerShape(
                    topStart = CornerSize(20.dp)
                )
            ) {
//                Image(
//                    painter = ,
//                    contentDescription =
//                )
            }
            Column (
                modifier = Modifier.padding(20.dp)
            ) {

            }
        }
    }
}

@Preview
@Composable
fun PreviewDetailPage() {
    DetailPage(
        navController = rememberNavController(),
        movieId = "123"
    )
}