package com.technipixl.and17_exo1.ui.screen

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

object LoginDestination {
    val route = "login"
}

fun NavGraphBuilder.loginGraph() {
    composable(
        route = LoginDestination.route,
    ) { backStackEntry ->
        LoginRoute()
    }
}