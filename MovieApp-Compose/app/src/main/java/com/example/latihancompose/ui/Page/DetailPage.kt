package com.example.latihancompose.ui.Page

import android.annotation.SuppressLint
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
import com.example.latihancompose.ui.model.Movie
import com.example.latihancompose.ui.model.getMovies
import com.example.latihancompose.ui.theme.White

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun DetailPage(
    navController: NavController,
    movieId: String?
) {
    val movie: Movie? = getMovies().firstOrNull { it.id == movieId }

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = "Detail Page",
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
        if (movie != null) {
            ContentDetailPage(movie = movie)
        }
    }
}

@Composable
fun ContentDetailPage(movie: Movie){
    var expanded by remember {
        mutableStateOf(false)
    }
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color(0xFF0F0602),
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.Start,
        ) {
            Surface (
                modifier = Modifier.fillMaxWidth()
                    .height(250.dp)
            ) {
                Image(
                    painter = rememberImagePainter(data = movie.image),
                    contentScale = ContentScale.Crop,
                    contentDescription = "Movie Poster",

                )
            }
            Surface(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(15.dp),
                color = Color.Gray,
                shape = RoundedCornerShape(
                    corner = CornerSize(20.dp)
                ),
                shadowElevation = 20.dp
            ) {
                Column(
                    modifier =
                    Modifier
                        .padding(20.dp)
                        .verticalScroll(rememberScrollState())
                ) {
                    Text(
                        text = movie.title,
                        style = TextStyle(
                            fontSize = 17.sp,
                            color = Color.Black,
                            fontWeight = FontWeight.Bold
                        ),
                    )
                    Text(
                        text = "Released: ${movie.year}",
                        style = TextStyle(
                            color = Color.Black,
                            fontSize = 15.sp,
                        ),
                        modifier = Modifier.padding(top = 5.dp)

                    )
                    Text(
                        text = "Director : ${movie.director}",
                        style = TextStyle(
                            color = Color.Black,
                            fontSize = 15.sp
                        ),
                        modifier = Modifier.padding(top = 5.dp)

                    )
                    Text(
                        text = "Actors : ${movie.actors}",
                        style = TextStyle(
                            color = Color.Black,
                            fontSize = 15.sp
                        ),
                        modifier = Modifier.padding(top = 5.dp)

                    )
                    Text(
                        text = "Rating : ${movie.rating}",
                        style = TextStyle(
                            color = Color.Black,
                            fontSize = 15.sp
                        ),
                        modifier = Modifier.padding(top = 5.dp)

                    )
                    Text(
                        text = "Plot : ${movie.plot}",
                        style = TextStyle(
                            color = Color.Black,
                            fontSize = 15.sp
                        ),
                        modifier = Modifier.padding(top = 5.dp)

                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun PreviewDetailPage() {
    ContentDetailPage(movie = getMovies()[0])
}
