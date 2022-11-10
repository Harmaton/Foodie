package com.njagi.foodie.presentation

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.base.R
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.njagi.foodie.data.recipe_dto.Recipes
import com.njagi.foodie.data.recipe_dto.RecipesItem
import com.njagi.foodie.presentation.common.HeaderText
import com.njagi.foodie.presentation.common.SearchInputBox
import com.njagi.foodie.presentation.common.TopAppSection
import com.njagi.foodie.presentation.destinations.RecipeDetailsScreenDestination
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
        when (val state = recipeViewModel.`recipe state`.collectAsState().value) {
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
            RecipeItemCard(recipeItem = recipes[it], navigator = navigator)
        }
    }
}

@Composable
fun RecipeItemCard(
    recipeItem: RecipesItem,
    navigator: DestinationsNavigator
) {
    Box(
        modifier = Modifier
            .width(200.dp)
            .height(200.dp)
            .background(Color.LightGray),
        propagateMinConstraints = true
    ) {
        Card(modifier = Modifier
            .height(150.dp)
            .fillMaxWidth()
            .clickable {
                // am trying to navigate to the details screen here
                navigator.navigate(RecipeDetailsScreenDestination())
            },
            border = BorderStroke(1.dp, Color.Black)
        ) {
            Image(
                painter = rememberAsyncImagePainter(
                    ImageRequest.Builder(LocalContext.current)
                        .data(data = recipeItem.image)
                        .apply(block = fun ImageRequest.Builder.() {
                            placeholder(R.drawable.notification_template_icon_bg)
                            crossfade(true)
                        }).build()
                ), contentDescription = null,
                modifier = Modifier
                    .fillMaxSize(),
                contentScale = ContentScale.FillBounds
            )
        }
        Row(
            verticalAlignment = Alignment.Bottom,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.padding(4.dp)
        ) {
            Text(
                text = recipeItem.title,
                maxLines = 2,
                fontSize = 16.sp,
                fontWeight = FontWeight.SemiBold
            )
        }
    }


}



