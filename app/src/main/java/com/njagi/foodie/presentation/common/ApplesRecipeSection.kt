package com.njagi.foodie.presentation.common

import android.service.autofill.OnClickAction
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.njagi.foodie.model_recipe.Recipes
import com.njagi.foodie.model_recipe.RecipesItem
import com.njagi.foodie.presentation.destinations.RecipeDetailsScreenDestination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Composable
fun RecipeItemCard(RecipeItem :RecipesItem, navigator: DestinationsNavigator) {
Box(modifier = Modifier
    .width(200.dp)
    .height(200.dp).background(Color.LightGray),
    propagateMinConstraints = true) {
    Card(modifier = Modifier
        .height(150.dp)
        .fillMaxWidth().clickable {
                                  navigator.navigate(RecipeDetailsScreenDestination())
        }
        ,
        border = BorderStroke(1.dp, Color.Black)
    ) {
        Image(painter = rememberAsyncImagePainter(
            ImageRequest.Builder(LocalContext.current)
                .data(data = RecipeItem.image)
                .apply (block = fun ImageRequest.Builder.() {
                    placeholder(coil.base.R.drawable.notification_template_icon_bg)
                    crossfade(true)
                }).build()

        ), contentDescription = null,
            modifier = Modifier
                .fillMaxSize(),
            contentScale = ContentScale.FillBounds)
    }

    Row(
        verticalAlignment = Alignment.Bottom,
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier.padding(4.dp)
    ) {
        Text(
            text = RecipeItem.title,
            maxLines = 2,
            fontSize = 16.sp,
            fontWeight = FontWeight.SemiBold
        )
    }
}


}


