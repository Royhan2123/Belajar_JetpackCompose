package com.example.latihancompose.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Surface
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.VisibilityOff
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.latihancompose.R
import com.example.latihancompose.Widget.ButtonStyle
import com.example.latihancompose.Widget.TextFieldStyle
import com.example.latihancompose.ui.theme.Blue
import com.example.latihancompose.ui.theme.Grey

@Composable
fun Login(navController: NavController) {
    val txtEmail = remember {
        mutableStateOf("")
    }
    val txtPassword = remember {
        mutableStateOf("")
    }
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color.White,
    ) {
        Card(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp)
                .background(color = Color.White),
            elevation = 20.dp,
            shape = RoundedCornerShape(
                corner = CornerSize(20.dp)
            ),
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(20.dp),
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 20.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "Login Your Account",
                        style = TextStyle(
                            fontSize = 20.sp,
                            color = Color.Black,
                            fontFamily = FontFamily.SansSerif,
                        ),
                    )
                }
                TextFieldStyle(
                    enabled = true,
                    modifier = Modifier.padding(top = 150.dp),
                    valueState = txtEmail,
                    labelId = "Email",
                    isSingleLine = true,
                    trailingIcon = {
                        Icon(
                            imageVector = Icons.Rounded.Email, contentDescription = "Email"
                        )
                    },
                    keyboardType = KeyboardType.Email,
                )
                TextFieldStyle(
                    enabled = true,
                    modifier = Modifier.padding(top = 15.dp),
                    valueState = txtPassword,
                    labelId = "Password",
                    isSingleLine = true,
                    trailingIcon = {
                        Icon(
                            imageVector = Icons.Rounded.VisibilityOff,
                            contentDescription = "Password"
                        )
                    },
                    keyboardType = KeyboardType.Password,
                )
                ButtonStyle(
                    txt = "Login", onItemClick = {
                        navController.navigate(
                            NavigationScreen.HomePage.name
                        )
                    }, modifier = Modifier.padding(top = 20.dp, bottom = 10.dp), enabled = true
                )
                Box(
                    modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.BottomEnd
                ) {
                    TextButton(onClick = {}) {
                        Text(
                            text = "Forgot Your Password", style = TextStyle(
                                color = Blue, fontSize = 13.sp
                            )
                        )
                    }
                }
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 20.dp)
                ) {
                    Text(
                        text = "-- or sign with --", style = TextStyle(
                            fontSize = 15.sp, color = Grey
                        )
                    )
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(80.dp)
                        .padding(top = 15.dp),
                    horizontalArrangement = Arrangement.Center,
                ) {
                    Surface(
                        modifier = Modifier.size(50.dp), shape = CircleShape
                    ) {
                        Image(
                            painter = painterResource(
                                id = R.drawable.facebook
                            ), contentDescription = "facebook"
                        )
                    }
                    Spacer(
                        modifier = Modifier.padding(
                            start = 10.dp
                        )
                    )
                    Surface(
                        modifier = Modifier.size(50.dp), shape = CircleShape
                    ) {
                        Image(
                            painter = painterResource(
                                id = R.drawable.google
                            ), contentDescription = "google"
                        )
                    }
                    Spacer(
                        modifier = Modifier.padding(
                            end = 10.dp
                        )
                    )
                    Surface(
                        modifier = Modifier.size(50.dp), shape = CircleShape
                    ) {
                        Image(
                            painter = painterResource(
                                id = R.drawable.twitter
                            ), contentDescription = "twitter"
                        )
                    }
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(100.dp)
                        .padding(top = 50.dp),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Text(
                        text = "dont have account?", style = TextStyle(
                            fontSize = 13.sp, color = Color.Gray
                        ), modifier = Modifier.padding(start = 4.dp)
                    )
                    TextButton(onClick = {
                        navController.navigate(
                            NavigationScreen.Register.name
                        )
                    }) {
                        Text(
                            text = "Sign Up", style = TextStyle(
                                color = Blue, fontSize = 13.sp
                            ), modifier = Modifier.padding(end = 4.dp)

                        )
                    }
                }

            }
        }
    }
}

@Preview
@Composable
fun PreviewLogin() {
    Login(navController = rememberNavController())
}