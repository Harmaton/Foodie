package com.njagi.foodie.presentation

import androidx.compose.foundation.layout.*
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.njagi.foodie.presentation.common.RecipeSection
import com.njagi.foodie.presentation.nav.BottomBar
import com.njagi.foodie.presentation.common.TopAppSection
import com.njagi.foodie.viewmodels.RecipeState
import com.njagi.foodie.viewmodels.RecipeViewModel

@Composable
fun HomeScreen() {
    val navcontroller = rememberNavController()

    Scaffold(
        topBar = { TopAppSection()},
        bottomBar = { BottomBar(navHostController = navcontroller) }

    ) { paddingValues ->
    Column(modifier = Modifier
        .padding(paddingValues)
        .fillMaxSize()) {
        FetchRecipeData()
        Spacer(modifier = Modifier.height(10.dp))
       Text(text = "Done")
    }

    }
}

@Composable
fun FetchRecipeData(
recipeViewModel: RecipeViewModel = viewModel()
)
{
Column(modifier = Modifier
    .padding(10.dp)
    .fillMaxSize()) {
    when(val state = recipeViewModel.recipestate.collectAsState().value){

        is RecipeState.Empty -> Text(text = "Empty")
        is RecipeState.Loading -> Text(text = "Loading ...")
        is RecipeState.Success -> RecipeSection(recipes = state.data)
        is RecipeState.Error -> Text(text = state.message)

    }

}
}

//@Composable
//fun FetchRandomMeal(
//
//)
//{
//    Column(modifier = Modifier
//        .padding(10.dp)
//        .fillMaxSize()) {
//        when(){
//
//
//        }
//
//    }
//}