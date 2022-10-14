package com.njagi.foodie.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.base.R
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.njagi.foodie.model_recipe.RecipesItem
import com.njagi.foodie.viewmodels.RecipeItemstate
import com.njagi.foodie.viewmodels.RecipeState
import com.njagi.foodie.viewmodels.RecipeViewModel
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Destination
@Composable
fun RecipeDetailsScreen(
    recipeItem: RecipesItem,
    navigator: DestinationsNavigator
) {

 val recipeViewModel : RecipeViewModel = hiltViewModel()

    Column(modifier = Modifier.fillMaxSize()
    , verticalArrangement = Arrangement.spacedBy(12.dp) ){


        //navigation back
        Row(modifier= Modifier
            .fillMaxWidth()
            .padding(start = 15.dp),
       verticalAlignment = Alignment.CenterVertically){

 IconButton(onClick = { navigator.popBackStack() }, ) {
     Icon(imageVector = Icons.Default.ArrowBack, contentDescription = null, tint = Color.Black)
 }
        }

        when(val state = recipeViewModel.recipeitemstate.collectAsState().value){

            is RecipeItemstate.Empty -> Text(text = "Empty")

            is RecipeItemstate.Loading -> Text(text = " Loading ...")

            is RecipeItemstate.Success ->  Column(modifier = Modifier.fillMaxSize()) {

                FetchDetails(recipeItem = state.data)
            }

            is RecipeItemstate.Error -> Text(text = state.message)

        }


    }

}

@Composable
fun FetchDetails(recipeItem: RecipesItem) {

    Image(painter = rememberAsyncImagePainter(
        ImageRequest.Builder(LocalContext.current)
            .data(data = recipeItem.image)
            .apply (block = fun ImageRequest.Builder.() {
                placeholder(coil.base.R.drawable.notification_template_icon_bg)
                crossfade(true)
            }).build()

    ), contentDescription = null,
        modifier = Modifier
            .fillMaxSize(),
        contentScale = ContentScale.FillBounds)
}