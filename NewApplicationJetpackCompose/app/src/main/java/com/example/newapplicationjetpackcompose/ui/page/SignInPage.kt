package com.example.newapplicationjetpackcompose.ui.page

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.newapplicationjetpackcompose.R
import com.example.newapplicationjetpackcompose.navigation.NavigationScreen
import com.example.newapplicationjetpackcompose.ui.theme.LightBlue

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignInPage(navController: NavController) {
    var txtGmail by rememberSaveable {
        mutableStateOf("")
    }
    var txtPassword by rememberSaveable {
        mutableStateOf("")
    }
    val keyboardController = LocalSoftwareKeyboardController.current

    var obsucureText by remember {
        mutableStateOf(true)
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
    ) {
        Text(
            text = "Login Your Account",
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(top = 30.dp),
            style = TextStyle(
                fontSize = 18.sp
            )
        )
        Spacer(modifier = Modifier.height(50.dp))
        Text(
            text = "Gmail",
            fontSize = 15.sp,
            color = Color.Black,
        )
        Spacer(modifier = Modifier.height(10.dp))
        OutlinedTextField(
            value = txtGmail,
            onValueChange = { txtGmail = it },
            modifier = Modifier
                .fillMaxWidth()
                .height(55.dp),
            placeholder = {
                Text(
                    text = "example@gmail.com",
                    style = TextStyle(
                        color = Color.Gray,
                        fontSize = 15.sp
                    ),
                )
            },
            maxLines = 1,
            singleLine = true,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Email,
                imeAction = ImeAction.Done
            ),
            keyboardActions = KeyboardActions(
                onDone = {
                    keyboardController?.hide()
                }
            ),
            textStyle = TextStyle(
                fontSize = 14.sp,
                color = Color.Black,
            ),
            shape = RoundedCornerShape(
                10.dp
            )
        )
        Spacer(modifier = Modifier.height(25.dp))
        Text(
            text = "Password",
            fontSize = 15.sp,
            color = Color.Black,
        )
        Spacer(modifier = Modifier.height(10.dp))
        OutlinedTextField(
            value = txtPassword,
            onValueChange = { txtPassword = it },
            modifier = Modifier
                .fillMaxWidth()
                .height(55.dp),
            placeholder = {
                Text(
                    text = "enter password",
                    style = TextStyle(
                        color = Color.Gray,
                        fontSize = 15.sp
                    ),
                )
            },
            maxLines = 1,
            singleLine = true,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Password,
                imeAction = ImeAction.Done
            ),
            keyboardActions = KeyboardActions(
                onDone = {
                    keyboardController?.hide()
                }
            ),
            textStyle = TextStyle(
                fontSize = 14.sp,
                color = Color.Black,
            ),
            shape = RoundedCornerShape(
                10.dp
            ),
            visualTransformation = if (obsucureText)
                PasswordVisualTransformation()
            else VisualTransformation.None,
            trailingIcon = {
                IconButton(onClick = {
                    obsucureText = !obsucureText
                }) {
                    val visibilityIcon = if (obsucureText)
                        Icons.Filled.VisibilityOff
                    else Icons.Filled.Visibility

                    val description = if (obsucureText)
                        "Hide Password"
                    else "Show Password"

                    Icon(
                        imageVector = visibilityIcon,
                        contentDescription = description
                    )
                }
            }
        )
        TextButton(
            onClick = {/*TODO NOTHING HERE*/ },
            modifier = Modifier.align(
                Alignment.End
            )
        ) {
            Text(
                text = "Forgot Password",
                style = TextStyle(
                    color = LightBlue,
                    fontSize = 14.sp
                )
            )
        }
        Button(
            onClick = {
                navController.navigate(
                    NavigationScreen.HalamanBottom.name
                )
            },
            modifier = Modifier
                .width(300.dp)
                .height(45.dp)
                .align(Alignment.CenterHorizontally),
            colors = ButtonDefaults.buttonColors(
                LightBlue
            ),
            shape = RoundedCornerShape(
                size = 10.dp
            )
        ) {
            Text(
                text = "Login", style = TextStyle(
                    color = Color.White,
                    fontSize = 15.sp
                )
            )
        }
        Spacer(modifier = Modifier.height(30.dp))
        Text(
            text = "--- or login with ---",
            style = TextStyle(
                color = Color.Gray,
                fontSize = 15.sp,
            ),
            modifier = Modifier.align(
                Alignment.CenterHorizontally
            )
        )
        Spacer(modifier = Modifier.height(20.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(
                    id = R.drawable.facebook,
                ),
                contentDescription = "image-facebook",
                contentScale = ContentScale.Crop,
                modifier = Modifier.size(50.dp)
            )
            Spacer(modifier = Modifier.width(10.dp))
            Image(
                painter = painterResource(
                    id = R.drawable.google,
                ),
                contentDescription = "image-google",
                contentScale = ContentScale.Crop,
                modifier = Modifier.size(50.dp)
            )
            Spacer(modifier = Modifier.width(10.dp))
            Image(
                painter = painterResource(
                    id = R.drawable.twitter,
                ),
                contentDescription = "image-twitter",
                contentScale = ContentScale.Crop,
                modifier = Modifier.size(50.dp)
            )

        }
        Spacer(modifier = Modifier.height(20.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Don't have account?",
                style = TextStyle(
                    fontSize = 13.sp,
                    color = Color.Gray,
                    fontWeight = FontWeight.SemiBold
                )
            )
            TextButton(
                onClick = {
                    navController.navigate(
                        NavigationScreen.SignUpPage.name
                    )
                },
            ) {
                Text(
                    text = "SignUp",
                    style = TextStyle(
                        color = LightBlue,
                        fontSize = 13.sp
                    )
                )
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun PreviewSignInPage() {
    SignInPage(navController = rememberNavController())
}

