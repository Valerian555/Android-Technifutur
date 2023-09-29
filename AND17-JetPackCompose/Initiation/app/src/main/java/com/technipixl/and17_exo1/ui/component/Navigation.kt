package com.technipixl.and17_exo1.ui.component

import androidx.compose.foundation.border
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.EmojiEmotions
import androidx.compose.material.icons.filled.EmojiFoodBeverage
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.technipixl.and17_exo1.R
import com.technipixl.and17_exo1.ui.screen.FoodDestination
import com.technipixl.and17_exo1.ui.screen.FunDestination
import com.technipixl.and17_exo1.ui.screen.LoginDestination
import com.technipixl.and17_exo1.ui.theme.AND17Exo1Theme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddAppBar() {
    TopAppBar(
        title = {
            Text(stringResource(id = R.string.app_name))
        },
        colors = TopAppBarDefaults.largeTopAppBarColors(
            containerColor = Color.Black,
            scrolledContainerColor = Color.White,
            navigationIconContentColor = Color.White,
            titleContentColor = Color.White,
            actionIconContentColor = Color.White
        )
    )
}

@Composable
fun AddFloatingButton() {
    FloatingActionButton(onClick = {
        // do sth
    }, content = {
        Icon(
            imageVector = Icons.Filled.Add,
            contentDescription = "Add"
        )
    })
}

@Composable
fun AddBottomNavigation(navController: NavController) {

    BottomNavigation {
        var selectedItem by remember { mutableStateOf(0) }

        BottomNavigationItem(
            icon = {
                Icon(
                    Icons.Filled.Home,
                    contentDescription = "Home",
                    tint = if (selectedItem == 0) Color.White else Color.Black)
                   },
            label = {
                Text(
                    text = "Home",
                    color = if (selectedItem == 0) Color.White else Color.Black)
                    },
            selected = selectedItem == 0,
            onClick = {
                selectedItem = 0
                      navigateTo(navController, LoginDestination.route)
                      },
            modifier = Modifier.border(width = 4.dp, Color.White)
        )

        BottomNavigationItem(
            icon = {
                Icon(
                Icons.Filled.EmojiEmotions,
                    contentDescription = "Fun",
                    tint = if (selectedItem == 1) Color.White else Color.Black)
                   },
            label = {
                Text(
                    text = "Fun",
                    color = if (selectedItem == 1) Color.White else Color.Black)
                    },
            selected = selectedItem == 1,
            onClick = {
                selectedItem = 1
                navigateTo(navController, FunDestination.route)}
        )

        BottomNavigationItem(
            icon = {
                Icon(
                    Icons.Filled.EmojiFoodBeverage,
                    contentDescription = "Food",
                    tint = if (selectedItem == 2) Color.White else Color.Black)
                   },
            label = {
                Text(
                    text = "Food",
                    color = if (selectedItem == 2) Color.White else Color.Black)
                    },
            selected = selectedItem == 2,
            onClick = {
                selectedItem = 2
                navigateTo(navController, FoodDestination.route)}
        )
    }
}

@Preview(showBackground = true)
@Composable
fun AddAppBarPreview() {
    AND17Exo1Theme {
        AddAppBar()
    }
}

private fun navigateTo(navController: NavController,route: String) {
    navController.navigate(route) {
        popUpTo(navController.graph.startDestinationId) {
            saveState= true
        }
        launchSingleTop = true
        restoreState = true
    }
}