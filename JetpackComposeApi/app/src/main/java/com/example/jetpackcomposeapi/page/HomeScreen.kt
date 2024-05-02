package com.example.jetpackcomposeapi.page

import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CameraAlt
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.Composable
import androidx.compose.material3.Surface
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.jetpackcomposeapi.R
import com.example.jetpackcomposeapi.ui.theme.lightGray
import com.example.jetpackcomposeapi.widget.CardDestination

@Composable
fun HomeScreen(
    navController: NavController
) {
    var txfSearch by rememberSaveable {
        mutableStateOf("")
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column {
                Text(
                    text = "Hello, Royhan",
                    fontSize = 17.sp,
                )
                Text(
                    text = "How are you today?",
                    fontSize = 16.sp,
                    color = Color.Gray,
                    fontWeight = FontWeight.Medium
                )

            }

            Surface(
                modifier = Modifier
                    .height(70.dp)
                    .width(70.dp),
                color = lightGray,
                shape = CircleShape
            ) {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = Icons.Filled.CameraAlt,
                        contentDescription = null,
                        modifier = Modifier.size(30.dp),
                        tint = Color.Black
                    )
                }
            }
        }
        Spacer(modifier = Modifier.height(50.dp))
        OutlinedTextField(
            value = txfSearch,
            onValueChange = { txfSearch = it },
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
            placeholder = {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Search your destination...",
                        fontSize = 15.sp,
                        color = Color.Gray,
                        fontWeight = FontWeight.Bold,
                    )
                }
            },
            textStyle = TextStyle(
                fontSize = 15.sp,
                color = Color.Black,
            ),
            leadingIcon = {
                Icon(
                    imageVector = Icons.Filled.Search,
                    contentDescription = "Search",
                    modifier = Modifier.size(20.dp),
                    tint = Color.Gray
                )
            },
            shape = RoundedCornerShape(size = 15.dp)
        )
        Spacer(modifier = Modifier.height(30.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .horizontalScroll(rememberScrollState())
        ) {
            CardDestination(
                nameCity = "Bali",
                nameDestination = "Monkey Forest",
                rating = 4.2,
                image = R.drawable.monkey_forest
            )
            Spacer(modifier = Modifier.width(20.dp))
            CardDestination(
                nameCity = "Bali",
                nameDestination = "Pura Besakih",
                rating = 4.8,
                image = R.drawable.pura_besakih
            )
            Spacer(modifier = Modifier.width(20.dp))

            CardDestination(
                nameCity = "Bali",
                nameDestination = "Seminyak",
                rating = 4.5,
                image = R.drawable.seminyak
            )
            Spacer(modifier = Modifier.width(20.dp))

            CardDestination(
                nameCity = "Bali",
                nameDestination = "Gunung Batur",
                rating = 4.3,
                image = R.drawable.gunung_batur
            )
            Spacer(modifier = Modifier.width(20.dp))

            CardDestination(
                nameCity = "Bali",
                nameDestination = "Air Terjun Tegunungan",
                rating = 5.0,
                image = R.drawable.air_terjun_tegunungan
            )
        }
    }
}


@Preview
@Composable
fun PreviewHomeScreen() {
    HomeScreen(navController = rememberNavController())
}