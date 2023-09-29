package com.technipixl.and17_exo1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCompositionContext
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.technipixl.and17_exo1.ui.component.AddAppBar
import com.technipixl.and17_exo1.ui.component.AddBottomNavigation
import com.technipixl.and17_exo1.ui.component.AddFloatingButton
import com.technipixl.and17_exo1.ui.screen.AddAuthentication
import com.technipixl.and17_exo1.ui.screen.LoginDestination
import com.technipixl.and17_exo1.ui.screen.LoginRoute
import com.technipixl.and17_exo1.ui.screen.foodGraph
import com.technipixl.and17_exo1.ui.screen.funGraph
import com.technipixl.and17_exo1.ui.screen.loginGraph
import com.technipixl.and17_exo1.ui.theme.AND17Exo1Theme
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.lifecycle.HiltViewModel
@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AND17Exo1Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainScreenView()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
@Preview
fun MainScreenView() {

    val navController = rememberNavController()

    Scaffold(
        topBar = {
                 AddAppBar()
        },
        bottomBar = {
                    AddBottomNavigation(navController)
        },
        floatingActionButton = {
            AddFloatingButton()
        }) { padding ->

        NavHost(
            navController = navController,
            startDestination = LoginDestination.route,
            modifier = Modifier
                .layoutId("navHost")
                .padding(padding),
            builder= {
                loginGraph()
                funGraph()
                foodGraph()
            }
           )
    }
}

