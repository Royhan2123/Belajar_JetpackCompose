package com.example.newapplicationjetpackcompose.ui.page

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

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

    var obsucureText by rememberSaveable {
        mutableStateOf(false)
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
                .padding(top = 50.dp),
            style = TextStyle(
                fontSize = 18.sp
            )
        )
        Spacer(modifier = Modifier.height(75.dp))
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
                        Icons.Filled.Visibility
                    else Icons.Filled.VisibilityOff

                    val description = if (obsucureText)
                        "Show Password"
                    else "Hide Password"

                    Icon(
                        imageVector = visibilityIcon,
                        contentDescription = description
                    )
                }
            }
        )
    }
}

@Preview(showSystemUi = true)
@Composable
fun PreviewSignInPage() {
    SignInPage(navController = rememberNavController())
}

