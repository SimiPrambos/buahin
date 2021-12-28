package com.example.buahin.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.buahin.R
import com.example.buahin.ui.components.LoadingAnimation
import cz.levinzonr.saferoute.core.annotations.Route

@Route("splashScreen")
@Composable
fun SplashScreen() {
    Scaffold {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxSize(),
        ) {
            LoadingAnimation(
                animationId = R.raw.loading,
                modifier = Modifier.size(150.dp)
            )
        }
    }
}