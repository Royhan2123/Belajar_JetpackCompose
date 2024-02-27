package com.example.newapplicationjetpackcompose.ui.page


import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.newapplicationjetpackcompose.R
import com.example.newapplicationjetpackcompose.data.DataSource
import com.example.newapplicationjetpackcompose.model.Affirmation
import com.example.newapplicationjetpackcompose.ui.theme.LightBlue

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun HomePage(navController: NavController) {

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Latihan Lazy Column",
                        style = TextStyle(
                            color = Color.White,
                            fontSize = 18.sp
                        )
                    )
                },
                colors = TopAppBarDefaults.smallTopAppBarColors(
                    LightBlue
                )
            )

        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(10.dp),
            horizontalAlignment = Alignment.Start,
        ) {
            ListCard(affirmation = DataSource().loadAffirmations())
        }
    }
}

@Composable
fun ListCard(affirmation: List<Affirmation>) {
    LazyColumn {
        items(affirmation) { affirmations ->
            CardHomePage(affirmation = affirmations)
        }
    }
}

@Preview(showSystemUi = true, apiLevel = 33)
@Composable
fun PreviewListCard() {
    ListCard(affirmation = DataSource().loadAffirmations())
}

@Composable
fun CardHomePage(affirmation: Affirmation) {
    Card(
        elevation = 8.dp,
        shape = RoundedCornerShape(
            12.dp
        ),
        modifier = Modifier.padding(10.dp)
    ) {
        Column {
            Image(
                painter = painterResource(
                    id = affirmation.imageResourceId
                ),
                contentDescription = stringResource(
                    id = affirmation.stringResourceId
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(190.dp),
                contentScale = ContentScale.Crop
            )
            Text(
                text = LocalContext.current.getString(
                    affirmation.stringResourceId
                ),
                modifier = Modifier.padding(16.dp),
                style = MaterialTheme.typography.headlineSmall
            )
        }
    }
}


@Preview
@Composable
fun CardHomePagePreview() {
    CardHomePage(
        Affirmation(
            R.string.affirmation1,
            R.drawable.image1
        )
    )
}

@Preview(showSystemUi = true)
@Composable
fun PreviewHomePage() {
    HomePage(navController = rememberNavController())
}
