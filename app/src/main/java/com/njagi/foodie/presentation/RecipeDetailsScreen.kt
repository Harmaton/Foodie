package com.njagi.foodie.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.base.R
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.njagi.foodie.data.recipe_dto.RecipesItem
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Destination
@Composable
fun RecipeDetailsScreen(
    recipeItem : RecipesItem,
    navigator: DestinationsNavigator
) {

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

       FetchDetails(recipeItem = recipeItem)

    }

}

@Composable
fun FetchDetails(recipeItem: RecipesItem) {

    Image(painter = rememberAsyncImagePainter(
        ImageRequest.Builder(LocalContext.current)
            .data(data = recipeItem.image)
            .apply (block = fun ImageRequest.Builder.() {
                placeholder(R.drawable.notification_template_icon_bg)
                crossfade(true)
            }).build()

    ), contentDescription = null,
        modifier = Modifier
            .fillMaxSize(),
        contentScale = ContentScale.FillBounds)
}