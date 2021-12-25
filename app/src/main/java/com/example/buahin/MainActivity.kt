package com.example.buahin

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.buahin.navigation.Navigation
import com.example.buahin.ui.theme.BuahinTheme
import com.example.buahin.viewmodel.AuthViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val authViewModel by viewModels<AuthViewModel>()

    @ExperimentalMaterialApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val state = authViewModel.state.value
            val navController: NavHostController = rememberNavController()

            BuahinTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    Navigation(navController).Build(
                        if (state.isAuthenticated())
                            Navigation.MAIN_ROUTE
                        else
                            Navigation.AUTH_ROUTE
                    )
                }
            }
        }
    }
}
