package com.njagi.foodie.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.rememberNavController
import com.njagi.foodie.model_recipe.Recipes
import com.njagi.foodie.presentation.common.HeaderText
import com.njagi.foodie.presentation.common.RecipeItemCard
import com.njagi.foodie.presentation.common.SearchInputBox
import com.njagi.foodie.presentation.common.TopAppSection
import com.njagi.foodie.viewmodels.RecipeState
import com.njagi.foodie.viewmodels.RecipeViewModel
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.annotation.RootNavGraph
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@RootNavGraph(start = true)
@Destination
@Composable
fun HomeScreen(recipeViewModel: RecipeViewModel = hiltViewModel(),
               navigator : DestinationsNavigator
               ) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {

        TopAppSection()
        SearchInputBox()
        HeaderText(text = "Apple + Flour Recipes")

        when (val state = recipeViewModel.recipestate.collectAsState().value) {

            is RecipeState.Empty -> Text(text = "Empty")
            is RecipeState.Loading -> Text(text = "Loading ...")
            is RecipeState.Success -> Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(250.dp)
            ) {
               ApplesRecipeSection(recipes = state.data, navigator = navigator)
            }

            is RecipeState.Error -> Text(text = state.message)


        }

    }

}


@Composable
fun ApplesRecipeSection(recipes: Recipes, navigator : DestinationsNavigator) {
    LazyRow(modifier = Modifier
        .height(200.dp)
        .padding(top = 1.dp),
        contentPadding = PaddingValues(10.dp),
        horizontalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        items(recipes.size){
            RecipeItemCard(RecipeItem = recipes[it], navigator = navigator)
        }
    }
}



