package com.micromatic.basicmatics.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.navigation.compose.*
import com.micromatic.basicmatics.R
import com.micromatic.basicmatics.ui.screens.MainScreen
import com.micromatic.basicmatics.ui.screens.OpsScreen

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = AppScreens.MainScreen.route) {
        composable(route = AppScreens.MainScreen.route) {
            MainScreen(navController)
        }
        composable(route = AppScreens.DivideScreen.route) {
            OpsScreen(stringResource(R.string.divide))
        }
        composable(route = AppScreens.MultiplyScreen.route) {
            OpsScreen(stringResource(R.string.multiply))
        }
        composable(route = AppScreens.AddScreen.route) {
            OpsScreen(stringResource(R.string.add))
        }
        composable(route = AppScreens.SubtractScreen.route) {
            OpsScreen(stringResource(R.string.subtract))
        }
    }
}