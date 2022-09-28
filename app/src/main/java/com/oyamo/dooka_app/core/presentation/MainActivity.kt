package com.oyamo.dooka_app.core.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Surface
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.oyamo.dooka_app.NavGraphs
import com.oyamo.dooka_app.core.presentation.components.CustomScaffold
import com.oyamo.dooka_app.core.presentation.ui.theme.JoomiaTheme
import com.oyamo.dooka_app.destinations.AccountScreenDestination
import com.oyamo.dooka_app.destinations.CartScreenDestination
import com.oyamo.dooka_app.destinations.HomeScreenDestination
import com.oyamo.dooka_app.destinations.WishlistScreenDestination
import com.ramcosta.composedestinations.DestinationsNavHost
import com.ramcosta.composedestinations.rememberNavHostEngine
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JoomiaTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                ) {
                    val navController = rememberNavController()
                    val navHostEngine = rememberNavHostEngine()
                    val newBackStackEntry by navController.currentBackStackEntryAsState()
                    val route = newBackStackEntry?.destination?.route

                    CustomScaffold(
                        navController = navController,
                        showBottomBar = route in listOf(
                            HomeScreenDestination.route,
                            WishlistScreenDestination.route,
                            CartScreenDestination.route,
                            AccountScreenDestination.route
                        )
                    ) { innerPadding ->
                        Box(modifier = Modifier.padding(innerPadding)) {
                            DestinationsNavHost(
                                navGraph = NavGraphs.root,
                                navController = navController,
                                engine = navHostEngine
                            )
                        }
                    }
                }
            }
        }
    }
}