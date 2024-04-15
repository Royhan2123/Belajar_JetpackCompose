package com.example.learngetapi

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.learngetapi.ui.theme.greenColor

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavController) {
    // on below line we are specifying background color for our application
    Surface(
        // on below line we are specifying modifier and color for our app
        modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
    ) {
        // on the below line we are specifying the theme as the scaffold.
        Scaffold(
            // in scaffold we are specifying top bar.
            topBar = {

                // inside top bar we are specifying background color.
                TopAppBar(
                    // along with that we are specifying title for our top bar.
                    title = {

                        // in the top bar we are specifying tile as a text
                        Text(
                            // on below line we are specifying text to display in top app bar.
                            text = "Retrofit POST Request in Android",

                            // on below line we are specifying modifier to fill max width.
                            modifier = Modifier.fillMaxWidth(),

                            // on below line we are specifying text alignment.
                            textAlign = TextAlign.Center,

                            // on below line we are specifying color for our text.
                            color = Color.White
                        )
                    })
            }) {
            // on the below line we are calling the pop window dialog method to display ui.
            PostData()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun PostData() {
    val ctx = LocalContext.current

    val userName = remember {
        mutableStateOf(TextFieldValue(""))
    }
    val job = remember {
        mutableStateOf(TextFieldValue(""))
    }
    val response = remember {
        mutableStateOf("")
    }

    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Retrofit Post Request in Android",
            color = greenColor,
            fontSize = 20.sp,
            fontFamily = FontFamily.Default,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(5.dp))

        OutlinedTextField(
            value = userName.value,
            onValueChange = {
                userName.value = it
            },
            placeholder = {
                Text(text = "Enter your name")
            },
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            textStyle = TextStyle(
                color = Color.Black,
                fontSize = 15.sp
            ),
            singleLine = true
        )

        Spacer(modifier = Modifier.height(5.dp))

        OutlinedTextField(
            value = job.value,
            onValueChange = {
                job.value = it
            },
            placeholder = {
                Text(text = "Enter your job")
            },
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            textStyle = TextStyle(
                color = Color.Black,
                fontSize = 15.sp
            ),
            singleLine = true
        )

        Spacer(modifier = Modifier.height(10.dp))
        ElevatedButton(
            onClick = { /*TODO*/ },
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Text(text = "Post Data", modifier = Modifier.padding(8.dp))
        }
        Spacer(modifier = Modifier.height(20.dp))
        Text(
            text = response.value,
            color = Color.Black,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(10.dp)
                .fillMaxWidth(),
            textAlign = TextAlign.Center
        )
    }
}

@Composable
@Preview
fun PreviewHomeScreen() {
    HomeScreen(navController = rememberNavController())
}