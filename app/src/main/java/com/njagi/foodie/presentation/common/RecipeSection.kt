package com.njagi.foodie.presentation.common

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
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

@Composable
fun RecipeSection(recipes: Recipes) {
    LazyRow(modifier = Modifier
        .height(160.dp),
      contentPadding = PaddingValues(8.dp)
        ) {
        items(recipes.size){
            Recipe(RecipeItem = recipes[it])
        }
    }
}

@Composable
fun Recipe(RecipeItem :RecipesItem ) {
    Card(modifier = Modifier
        .height(150.dp)
        .width(150.dp),
    border = BorderStroke(1.dp, Color.Black),
        shape = RoundedCornerShape(4.dp)
        ) {
        Image(painter = rememberAsyncImagePainter(
            ImageRequest.Builder(LocalContext.current)
                .data(data = RecipeItem.image)
                .apply (block = fun ImageRequest.Builder.() {
                    placeholder(coil.base.R.drawable.notification_template_icon_bg)
                    crossfade(true)
                }).build()

        ), contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.FillBounds)

        Spacer(modifier = Modifier.height(4.dp))

        Row(modifier = Modifier.padding(4.dp),
        horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.Bottom
            ) {
            Text(
                text = RecipeItem.title,
                maxLines = 1,
                fontSize = 14.sp,
                fontWeight = FontWeight.SemiBold
            )
        }
    }
}