package com.technipixl.and17_exo1.ui.screen

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

object FunDestination {
    val route = "fun"
}

fun NavGraphBuilder.funGraph() {
    composable(
        route = FunDestination.route,
    ) { backStackEntry ->
        FunRoute()
    }
}