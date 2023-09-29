package com.technipixl.and17_exo1.ui.screen

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

object FoodDestination {
    val route = "food"
}

fun NavGraphBuilder.foodGraph() {
    composable(
        route = FoodDestination.route,
    ) { backStackEntry ->
        FoodRoute()
    }
}