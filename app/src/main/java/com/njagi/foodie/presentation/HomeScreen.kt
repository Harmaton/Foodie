package com.njagi.foodie.presentation

import androidx.compose.foundation.layout.*
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.njagi.foodie.presentation.common.RecipeSection
import com.njagi.foodie.presentation.nav.BottomBar
import com.njagi.foodie.presentation.common.TopAppSection
import com.njagi.foodie.viewmodels.RecipeState
import com.njagi.foodie.viewmodels.RecipeViewModel
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.annotation.RootNavGraph

@RootNavGraph(start = true)
@Destination
@Composable
fun HomeScreen(recipeViewModel: RecipeViewModel = hiltViewModel()) {

    Scaffold(
        topBar = { TopAppSection()}
    ) { paddingValues ->
    Column(modifier = Modifier
        .padding(paddingValues)
        .fillMaxSize()) {

            when(val state = recipeViewModel.recipestate.collectAsState().value){

                is RecipeState.Empty -> Text(text = "Empty")
                is RecipeState.Loading -> Text(text = "Loading ...")
                is RecipeState.Success -> RecipeSection(recipes = state.data)
                is RecipeState.Error -> Text(text = state.message)



        }

    }
}

@Composable
fun FetchRecipeData(
recipeViewModel: RecipeViewModel = viewModel()
)
{

}
}

