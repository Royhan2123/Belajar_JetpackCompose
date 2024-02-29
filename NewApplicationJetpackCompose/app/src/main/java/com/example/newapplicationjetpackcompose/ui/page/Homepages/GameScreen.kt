package com.example.newapplicationjetpackcompose.ui.page.Homepages

import android.annotation.SuppressLint
import android.app.Activity
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.MaterialTheme.shapes
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.newapplicationjetpackcompose.R
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.newapplicationjetpackcompose.ui.theme.LightBlue

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun GameScreen(navController: NavController) {
    val mediumPadding = dimensionResource(id = R.dimen.padding_medium)

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Latihan View Model",
                        style = typography.headlineSmall,
                        color = Color.White
                    )
                },
                colors = TopAppBarDefaults.smallTopAppBarColors(
                    LightBlue
                )
            )
        },
    ) {
        Column(
            modifier = Modifier
                .statusBarsPadding()
                .verticalScroll(rememberScrollState())
                .safeDrawingPadding()
                .padding(top = 60.dp, start = 20.dp, end = 20.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(20.dp))
            GameLayout(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .padding(mediumPadding)
            )
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(mediumPadding),
                verticalArrangement = Arrangement.spacedBy(mediumPadding),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Button(
                    modifier = Modifier.fillMaxWidth(),
                    onClick = { }
                ) {
                    Text(
                        text = stringResource(R.string.submit),
                        fontSize = 16.sp
                    )
                }
                OutlinedButton(
                    onClick = { /*TODO*/ }, modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = stringResource(id = R.string.skip), fontSize = 16.sp
                    )
                }
            }
            GameStatus(score = 0, modifier = Modifier.padding(20.dp))
        }
    }
}

@Composable
fun GameStatus(score: Int, modifier: Modifier = Modifier) {
    Card(
        modifier = Modifier
    ) {
        Text(
            text = stringResource(id = R.string.score, score),
            style = typography.headlineMedium,
            modifier = Modifier.padding(8.dp)
        )
    }
}

@Composable
private fun FinalScoreDialog(
    score: Int,
    onPlayAgain: () -> Unit,
    modifier: Modifier = Modifier
) {
    val activity = (LocalContext.current as Activity)
    AlertDialog(
        onDismissRequest = { /*TODO*/ },
        confirmButton = {
            TextButton(
                onClick = {
                    onPlayAgain()
                }) {
                Text(text = stringResource(id = R.string.play_again))
            }
        },
        modifier = modifier,
        text = {
            Text(text = stringResource(id = R.string.you_scored, score))
        },
        title = {
            Text(text = stringResource(id = R.string.congratulations))
        },
        dismissButton = {
            TextButton(
                onClick = {
                    activity.finish()
                }) {
                Text(text = stringResource(id = R.string.exit))
            }
        }
    )
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GameLayout(modifier: Modifier = Modifier) {
    val mediumPadding = dimensionResource(id = R.dimen.padding_medium)

    var txtGameField by remember {
        mutableStateOf("")
    }
    Card(
        elevation = CardDefaults.cardElevation(
            defaultElevation = 5.dp
        ),
        colors = CardDefaults.cardColors(
            colorScheme.surfaceTint
        )
    ) {
        Column(
            modifier = Modifier.padding(mediumPadding),
            verticalArrangement = Arrangement.spacedBy(mediumPadding),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                modifier = Modifier
                    .clip(shapes.medium)
                    .background(colorScheme.surfaceTint)
                    .padding(horizontal = 10.dp, vertical = 4.dp)
                    .align(alignment = Alignment.End),
                text = stringResource(id = R.string.word_count, 0),
                style = typography.titleMedium,
                color = colorScheme.onPrimary
            )

            Text(
                text = "Scrambleum",
                style = typography.displayMedium,
                color = Color.White
            )

            Text(
                text = stringResource(id = R.string.instructions),
                textAlign = TextAlign.Center,
                style = typography.titleMedium,
                color = Color.White
            )

            OutlinedTextField(
                value = txtGameField,
                onValueChange = { txtGameField = it },
                singleLine = true,
                shape = shapes.large,
                modifier = Modifier.fillMaxWidth(),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    containerColor = colorScheme.surface,
                ),
                label = {
                    Text(text = stringResource(id = R.string.enter_your_word))
                },
                isError = false,
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Text, imeAction = ImeAction.Done
                ),
                keyboardActions = KeyboardActions(
                    onDone = { }
                )
            )
        }
    }
}

@Preview
@Composable
fun PreviewGameLayout() {
    GameLayout()
}

@Preview(showSystemUi = true)
@Composable
fun PreviewGameScreen() {
    GameScreen(navController = rememberNavController())
}