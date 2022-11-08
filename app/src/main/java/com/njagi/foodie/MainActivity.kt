package com.njagi.foodie

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Surface
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.njagi.foodie.presentation.HomeScreen
import com.njagi.foodie.presentation.NavGraphs
import com.njagi.foodie.presentation.destinations.FavouritesScreenDestination
import com.njagi.foodie.presentation.destinations.HomeScreenDestination
import com.njagi.foodie.presentation.destinations.MealPlanScreenDestination
import com.njagi.foodie.presentation.nav.CustomBottomBar
import com.njagi.foodie.ui.theme.FoodieTheme
import com.ramcosta.composedestinations.DestinationsNavHost
import com.ramcosta.composedestinations.manualcomposablecalls.composable
import com.ramcosta.composedestinations.rememberNavHostEngine
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FoodieTheme {

                Surface(
                    modifier = Modifier.fillMaxSize(),
                ) {
                    val navController = rememberNavController()
                    val navHostEngine = rememberNavHostEngine()
                    val newBackStackEntry by navController.currentBackStackEntryAsState()
                    val route = newBackStackEntry?.destination?.route

                    CustomBottomBar(
                        navController = navController,
                        showBottomBar = route in listOf(
                            HomeScreenDestination.route,
                            FavouritesScreenDestination.route,
                            MealPlanScreenDestination.route

                        )
                    ) { innerPadding ->

                        Box(modifier = Modifier.padding(innerPadding)) {

                            DestinationsNavHost(navGraph = NavGraphs.root,
                                 navController = navController,
                                engine = navHostEngine
                                ){

                                composable(HomeScreenDestination){
                                    HomeScreen(
                                        recipeViewModel = hiltViewModel(),
                                        navigator = destinationsNavigator

                                    )
                                }
                            }
                        }


                    }
                }
            }
        }
    }
}

