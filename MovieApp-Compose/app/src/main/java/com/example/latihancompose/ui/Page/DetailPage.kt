package com.example.latihancompose.ui.Page

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
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
import androidx.navigation.compose.rememberNavController
import coil.compose.rememberImagePainter
import com.example.latihancompose.ui.model.getMovies
import com.example.latihancompose.ui.theme.White

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun ScafoldDetail(
    navController: NavController,
    movieId: String?
) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text(text = "DetailPage",
                    style = TextStyle(
                        color = White,
                        fontSize = 15.sp
                    )
                ) },
                colors = TopAppBarDefaults.smallTopAppBarColors(
                    Color(0xFF0F0602)
                ),
                navigationIcon = {
                    IconButton(
                        onClick = {
                            navController.popBackStack()
                        }) {
                        Icon(imageVector = Icons.Rounded.ArrowBack,
                            contentDescription = "Back",
                            tint = Color(0xFFD3D2D2),
                            modifier = Modifier.size(30.dp)
                        )
                    }
                }

            )
        }
    ) {
//        DetailPage(
//            navController = navController,
//            movieId = movieId
//        )
    }
}

@Composable
fun DetailPage(
    navController: NavController,
    movieId: String?,
) {
    val newMovieList = getMovies().filter { movie ->
        movie.id == movieId
    }

    val movieImage = newMovieList[0].images[1]
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color.White,
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.Start,
        ) {
//            Surface(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .height(200.dp),
//                color = Color.Black,
//            ) {
//                Image(
//                    painter = rememberImagePainter(
//                        data = movieImage
//                    ),
//                    contentScale = ContentScale.Crop,
//                    contentDescription = "Data"
//                )
//            }
            Column(
                modifier = Modifier.padding(20.dp)
            ) {

            }
        }
    }
}

@Preview
@Composable
fun PreviewDetailPage() {
//    DetailPage(
//        navController = rememberNavController(),
//        movieId = "123"
//    )
    ScafoldDetail(
        navController = rememberNavController(),
        movieId = "123"
    )
}