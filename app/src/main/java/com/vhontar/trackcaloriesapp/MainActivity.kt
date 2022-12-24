package com.vhontar.trackcaloriesapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.vhontar.core.navigation.Route
import com.vhontar.onboarding_presentation.welcome.screens.WelcomeScreen
import com.vhontar.trackcaloriesapp.navigation.navigate
import com.vhontar.trackcaloriesapp.ui.theme.CaloryTrackerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CaloryTrackerTheme {
                val navController = rememberNavController()
                NavHost(
                    navController = navController,
                    startDestination = Route.WELCOME
                ) {
                    // on boarding
                    composable(Route.WELCOME) {
                        WelcomeScreen(onNavigate = navController::navigate)
                    }
                    composable(Route.AGE) {

                    }
                    composable(Route.GENDER) {

                    }
                    composable(Route.HEIGHT) {

                    }
                    composable(Route.WEIGHT) {

                    }
                    composable(Route.NUTRIENT_GOAL) {

                    }
                    composable(Route.ACTIVITY) {

                    }
                    composable(Route.GOAL) {

                    }

                    // tracker
                    composable(Route.TRACKER_OVERVIEW) {

                    }
                    composable(Route.SEARCH) {

                    }
                }
            }
        }
    }
}