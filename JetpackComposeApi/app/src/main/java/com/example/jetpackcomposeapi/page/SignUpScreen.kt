package com.example.jetpackcomposeapi.page

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.ButtonDefaults.elevatedButtonColors
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Icon
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
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.jetpackcomposeapi.navigation.NavigationScreen

@Composable
fun SignUpScreen(
    navController: NavController
) {

    var txfName by rememberSaveable {
        mutableStateOf("")
    }

    var txfGmail by rememberSaveable {
        mutableStateOf("")
    }

    var txfPassword by rememberSaveable {
        mutableStateOf("")
    }

    val keyboardController =
        LocalSoftwareKeyboardController.current

    var obsucureText by remember {
        mutableStateOf(true)
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(
                20.dp
            )
    ) {
        Box(
            modifier = Modifier.align(Alignment.CenterHorizontally)
        ) {
            Text(
                text = "Register Your Account",
                textAlign = TextAlign.Center,
                fontSize = 16.sp,
                modifier = Modifier.padding(
                    top = 10.dp
                )
            )
        }
        Spacer(modifier = Modifier.height(85.dp))
        OutlinedTextField(
            value = txfName,
            onValueChange = { txfName = it },
            modifier = Modifier
                .fillMaxWidth()
                .height(55.dp),
            textStyle = TextStyle(
                color = Color.Black,
                fontSize = 15.sp
            ),
            shape = RoundedCornerShape(
                size = 10.dp
            ),
            singleLine = true,
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Done,
                keyboardType = KeyboardType.Text
            ),
            placeholder = {
                Text(
                    text = "enter your name",
                    color = Color.Gray,
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold
                )
            },
        )
        Spacer(modifier = Modifier.height(15.dp))
        OutlinedTextField(
            value = txfGmail,
            onValueChange = { txfGmail = it },
            modifier = Modifier
                .fillMaxWidth()
                .height(55.dp),
            textStyle = TextStyle(
                color = Color.Black,
                fontSize = 15.sp
            ),
            shape = RoundedCornerShape(
                size = 10.dp
            ),
            singleLine = true,
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Done,
                keyboardType = KeyboardType.Email
            ),
            placeholder = {
                Text(
                    text = "name@example.com",
                    color = Color.Gray,
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold
                )
            },
        )
        Spacer(modifier = Modifier.height(15.dp))
        OutlinedTextField(
            value = txfPassword,
            onValueChange = { txfPassword = it },
            modifier = Modifier
                .fillMaxWidth()
                .height(55.dp),
            textStyle = TextStyle(
                color = Color.Black,
                fontSize = 15.sp
            ),
            shape = RoundedCornerShape(
                size = 10.dp
            ),
            singleLine = true,
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Done,
                keyboardType = KeyboardType.Password
            ),
            placeholder = {
                Text(
                    text = "enter your password here",
                    color = Color.Gray,
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold
                )
            },
            keyboardActions = KeyboardActions(
                onDone = {
                    keyboardController?.hide()
                }
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
                        "Hide Passworf"
                    else "Show Password"

                    Icon(
                        imageVector = visibilityIcon,
                        contentDescription = description
                    )
                }
            }
        )
        Spacer(modifier = Modifier.height(20.dp))
        ElevatedButton(
            onClick = {
                navController.navigate(
                    NavigationScreen.HomeScreen.name
                )
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(45.dp),
            colors = elevatedButtonColors(
                Color.Blue
            ),
            enabled = true,
            shape = RoundedCornerShape(
                size = 15.dp
            )
        ) {
            Text(
                text = "Create Account",
                color = Color.White,
                fontSize = 14.sp
            )
        }
        Spacer(
            modifier = Modifier.height(20.dp)
        )
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Already have account?",
                fontSize = 13.sp,
                color = Color.Gray,
            )
            TextButton(onClick = {
                navController.navigate(
                    NavigationScreen.SignInScreen.name
                )
            }) {
                Text(
                    text = "SignIn",
                    fontSize = 13.sp,
                    color = Color.Blue,
                )
            }
        }
    }
}


@Preview(showSystemUi = true)
@Composable
fun PreviewSignUpScreen() {
    SignUpScreen(rememberNavController())
}