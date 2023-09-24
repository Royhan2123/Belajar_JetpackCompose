package com.example.buildmoviewithcompose.widgets

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import coil.transform.CircleCropTransformation
import com.bawp.movieapp.model.Movie
import com.bawp.movieapp.model.getMovies

@Preview
@Composable
fun CardMovie(
    movie: Movie = getMovies()[0],
    onItemClick: (String) -> Unit = {}
) {
    var expanded by remember {
        mutableStateOf(false)
    }
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
            .clickable {
                onItemClick(movie.id)
            }
            .padding(vertical = 10.dp),
        shape = RoundedCornerShape(corner = CornerSize(20.dp)),
        colors = CardDefaults.cardColors(
            Color.LightGray,
        ),
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize(),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Surface(
                modifier = Modifier
                    .width(150.dp)
                    .height(120.dp)
                    .padding(12.dp),
                shape = RoundedCornerShape(
                    corner = CornerSize(
                        10.dp
                    )
                ),
                shadowElevation = 20.dp,
            ) {
                Image(painter = rememberImagePainter(
                    data = movie.images[1],
                    builder = {
                        crossfade(true)
                        transformations(CircleCropTransformation())
                    }
                ),
                    contentDescription = "Movie Poster")
            }
            Column(
                modifier =
                Modifier.padding(4.dp)
            ) {
                Text(
                    text = movie.title,
                    style = TextStyle(
                        fontSize = 17.sp
                    )
                )
                Text(
                    text = "Director: ${movie.title}",
                    style = TextStyle(
                        fontSize = 15.sp
                    )
                )
                Text(
                    text = "Released: ${movie.year}",
                    style = TextStyle(
                        fontSize = 15.sp
                    )
                )
                AnimatedVisibility(visible = expanded) {
                    Column {
                        Text(buildAnnotatedString {
                            withStyle(
                                style = SpanStyle(
                                    color = Color.DarkGray,
                                    fontSize = 13.sp
                                )
                            ) {
                                append("Plot : ")
                            }
                            withStyle(
                                style = SpanStyle(
                                    color = Color.DarkGray,
                                    fontSize = 13.sp,
                                    fontWeight = FontWeight.Bold
                                )
                            ){
                                append(movie.plot)
                            }
                        })
                    }
                }

                Icon(
                    imageVector =
                    // disini kita lakukan operator tennary
                    // di kotlin sangat gampang sekali,
                    // tidak memerlukan ? dan :
                    if (expanded)
                        Icons.Filled.KeyboardArrowUp else
                        Icons.Filled.KeyboardArrowDown,
                    contentDescription = "Down Arrow",
                    modifier = Modifier
                        .size(30.dp)
                        .clickable {
                            expanded = !expanded
                        },
                    tint = Color.DarkGray
                )
            }
        }
    }
}
