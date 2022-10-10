package com.njagi.foodie.presentation.common

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.njagi.foodie.model_recipe.Recipes
import com.njagi.foodie.model_recipe.RecipesItem

@Composable
fun RecipeSection(recipes: Recipes) {
    LazyColumn(modifier = Modifier
        .fillMaxHeight()
        .fillMaxWidth()) {
        items(recipes.size){
            Recipe(RecipeItem = recipes[it])
        }
    }
}

@Composable
fun Recipe(RecipeItem :RecipesItem ) {
    Card(modifier = Modifier.fillMaxSize()) {
        Image(painter = rememberAsyncImagePainter(
            ImageRequest.Builder(LocalContext.current)
                .data(data = RecipeItem.image)
                .apply (block = fun ImageRequest.Builder.() {
                    placeholder(coil.base.R.drawable.notification_template_icon_bg)
                    crossfade(true)
                }).build()

        ), contentDescription = null,
            modifier = Modifier
                .width(100.dp)
                .height(100.dp),
            contentScale = ContentScale.FillWidth)

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = RecipeItem.title,
            maxLines = 1,
            fontSize = 14.sp,
            fontWeight = FontWeight.Light
        )
    }
}