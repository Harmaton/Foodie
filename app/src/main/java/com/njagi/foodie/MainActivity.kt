package com.njagi.foodie

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.njagi.foodie.presentation.HomeScreen
import com.njagi.foodie.presentation.NavGraphs
import com.njagi.foodie.presentation.destinations.HomeScreenDestination
import com.njagi.foodie.ui.theme.FoodieTheme
import com.ramcosta.composedestinations.DestinationsNavHost
import com.ramcosta.composedestinations.manualcomposablecalls.composable
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FoodieTheme {

           DestinationsNavHost(navGraph = NavGraphs.root){
               composable(HomeScreenDestination){
                   HomeScreen(
                       recipeViewModel = hiltViewModel()
                   )
               }
           }

            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    FoodieTheme {
       HomeScreen()
    }
}