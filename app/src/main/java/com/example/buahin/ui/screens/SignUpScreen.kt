/*
 * Copyright (C) 2021 SimiPrambos <simi.prambos@gmail.com> - All Rights Reserved
 * SignUpScreen.kt
 * Buahin <https://github.com/SimiPrambos/buahin.git>
 * UI Design by Afsar <https://www.figma.com/community/file/882645007956337261>
 */

package com.example.buahin.ui.screens

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.buahin.R
import com.example.buahin.ui.components.RoundedButton
import com.example.buahin.ui.theme.BuahinTheme
import com.example.buahin.ui.theme.Primary
import com.example.buahin.ui.theme.Shapes
import com.example.buahin.ui.theme.Typography
import com.example.buahin.viewmodel.AuthEvent
import com.example.buahin.viewmodel.AuthViewModel
import cz.levinzonr.saferoute.core.annotations.Route
import kotlinx.coroutines.launch

@Route("signUp")
@Composable
fun SignUpScreen(navController: NavController, vm: AuthViewModel = hiltViewModel()) {
    val nameState = remember {
        mutableStateOf(TextFieldValue())
    }
    val emailState = remember {
        mutableStateOf(TextFieldValue())
    }
    val passwordState = remember {
        mutableStateOf(TextFieldValue())
    }

    val scope = rememberCoroutineScope()

    fun onSignUpPressed() {
        navController.popBackStack()
        navController.navigateToSplashScreen()
        scope.launch {
            vm.onEvent(AuthEvent.SignUp(
                name = nameState.value.text,
                email = emailState.value.text,
                password = passwordState.value.text,
            ))
        }
    }

    Scaffold {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 20.dp)
                .verticalScroll(rememberScrollState()),
        ) {
            Spacer(modifier = Modifier.height(50.dp))
            Image(
                painter = painterResource(id = R.drawable.ic_logo_colorfull),
                contentDescription = "",
                alignment = Alignment.Center,
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(50.dp))
            Text(
                text = "SignUp",
                style = Typography.h4,
            )
            Spacer(modifier = Modifier.height(15.dp))
            Text(
                text = "Enter your credentials to continue",
                style = Typography.subtitle1,
            )
            Spacer(modifier = Modifier.height(40.dp))
            Text(
                text = "Full Name",
                style = Typography.subtitle1,
                lineHeight = 29.sp,
                fontWeight = FontWeight.SemiBold,
            )
            Spacer(modifier = Modifier.height(3.dp))
            OutlinedTextField(
                value = nameState.value,
                onValueChange = { nameState.value = it },
                placeholder = { Text(text = "John Doe") },
                modifier = Modifier.fillMaxWidth(),
                shape = Shapes.small,
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Next,
                )
            )
            Spacer(modifier = Modifier.height(20.dp))
            Text(
                text = "Email",
                style = Typography.subtitle1,
                lineHeight = 29.sp,
                fontWeight = FontWeight.SemiBold,
            )
            Spacer(modifier = Modifier.height(3.dp))
            OutlinedTextField(
                value = emailState.value,
                onValueChange = { emailState.value = it },
                placeholder = { Text(text = "you@mail.com") },
                modifier = Modifier.fillMaxWidth(),
                shape = Shapes.small,
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Email,
                    imeAction = ImeAction.Next,
                )
            )
            Spacer(modifier = Modifier.height(20.dp))
            Text(
                text = "Password",
                style = Typography.subtitle1,
                lineHeight = 29.sp,
                fontWeight = FontWeight.SemiBold,
            )
            Spacer(modifier = Modifier.height(3.dp))
            OutlinedTextField(
                value = passwordState.value,
                onValueChange = { passwordState.value = it },
                placeholder = { Text(text = "my secret password") },
                modifier = Modifier.fillMaxWidth(),
                shape = Shapes.small,
                visualTransformation = PasswordVisualTransformation(),
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Password,
                    imeAction = ImeAction.Go,
                )
            )
            Row(
                horizontalArrangement = Arrangement.End,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp)
            ) {
                TextButton(onClick = { /*TODO*/ }) {
                    Text(
                        text = "Forgot Password?",
                        color = Color.Black,
                        textAlign = TextAlign.Right
                    )
                }
            }
            Spacer(modifier = Modifier.height(30.dp))
            RoundedButton.Filled(label = "Sign Up", onClick = ::onSignUpPressed)
            Spacer(modifier = Modifier.height(25.dp))
            Row(horizontalArrangement = Arrangement.Center, modifier = Modifier.fillMaxWidth()) {
                Text(text = "Already have an account? ")
                Text(text = "Sign In", color = Primary, modifier = Modifier.clickable {
                    navController.popBackStack()
                    navController.navigateToSignIn()
                })
            }
        }
    }
}

@Preview
@Composable
fun SignUpScreenPreview() {
    BuahinTheme {
        SignUpScreen(rememberNavController())
    }
}