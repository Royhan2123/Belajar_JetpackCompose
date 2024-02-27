package com.example.newapplicationjetpackcompose.ui.page.Homepages


import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.newapplicationjetpackcompose.R
import com.example.newapplicationjetpackcompose.data.DataSource
import com.example.newapplicationjetpackcompose.model.Affirmation
import com.example.newapplicationjetpackcompose.navigation.NavigationScreen
import com.example.newapplicationjetpackcompose.ui.theme.LightBlue

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun HomePage(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        ElevatedButton(
            onClick = {
                navController.navigate(
                    NavigationScreen.LatihanLazyColumn.name
                )
            },
            modifier = Modifier
                .width(250.dp)
                .height(60.dp),
            colors = ButtonDefaults.buttonColors(
                LightBlue
            )
        ) {
            Text(
                text = "Go to Exercise Lazy Column",
                style = TextStyle(
                    color = Color.White,
                    fontSize = 15.sp
                )
            )
        }
        Spacer(modifier = Modifier.height(20.dp))
        ElevatedButton(
            onClick = {
                /**
                 * TODO THIS BUTTON NOT HAVE FUNCTION
                 */
            },
            modifier = Modifier
                .width(250.dp)
                .height(60.dp),
            colors = ButtonDefaults.buttonColors(
                LightBlue
            )
        ) {
            Text(
                text = "Go to Exercise Simple Animation",
                style = TextStyle(
                    color = Color.White,
                    fontSize = 15.sp
                ),
                textAlign = TextAlign.Center
            )
        }
    }
}

@Preview(
    showSystemUi = true,
)
@Composable
fun PreviewHomePages() {
    HomePage(navController = rememberNavController())
}
