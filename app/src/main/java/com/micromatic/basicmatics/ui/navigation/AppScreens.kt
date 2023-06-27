package com.micromatic.basicmatics.ui.navigation

sealed class AppScreens(val route: String) {
    object MainScreen: AppScreens("main_screen")
    object DivideScreen: AppScreens("div_screen")
    object MultiplyScreen: AppScreens("mtpl_screen")
    object AddScreen: AppScreens("add_screen")
    object SubtractScreen: AppScreens("subt_screen")
}
