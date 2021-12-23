package com.example.buahin.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.buahin.R
import com.example.buahin.ui.theme.BuahinTheme
import com.example.buahin.ui.theme.Typography
import cz.levinzonr.saferoute.core.annotations.Route

@Route("onboarding")
@Composable
fun OnboardingScreen(navController: NavController) {
    Box {
        Image(
            painter = painterResource(id = R.drawable.onboarding),
            contentDescription = "",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.FillBounds,
        )
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 30.dp),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_logo),
                contentDescription = "",
                alignment = Alignment.Center,
            )
            Spacer(modifier = Modifier.height(30.dp))
            Text(
                text = "Welcome to our store",
                style = Typography.h3,
                textAlign = TextAlign.Center
            )
            Text(
                text = "Ger your groceries in as fast as one hour",
                fontSize = 16.sp,
                color = Color.White,
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(40.dp))
            Button(
                onClick = {
                    navController.popBackStack()
                    navController.navigateToSignIn()
                },
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(18.dp),
                contentPadding = PaddingValues(vertical = 20.dp)
            ) {
                Text(text = "Get Started")
            }
            Spacer(modifier = Modifier.height(90.dp))
        }
    }
}

@Preview
@Composable
fun OnboardingScreenPreview() {
    BuahinTheme {
        OnboardingScreen(rememberNavController())
    }
}