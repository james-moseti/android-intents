package com.jmcoding.intentsapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.jmcoding.intentsapp.ui.theme.IntentsAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            IntentsAppTheme {
                AppNavigation()
            }
        }
    }
}

@Composable
fun AppNavigation() {
    // NavController manages which screen is currently shown
    val navController = rememberNavController()

    // NavHost defines all the screens and which is the start
    NavHost(
        navController = navController,
        startDestination = "home"
    ) {
        composable("home") {
            HomeScreen(
                onGoToSecond = { navController.navigate("second") }
            )
        }

        composable("second") {
            SecondScreen(
                onGoBack = { navController.popBackStack() }
            )
        }
    }
}