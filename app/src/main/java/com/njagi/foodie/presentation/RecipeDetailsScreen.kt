package com.njagi.foodie.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.njagi.foodie.R
import com.njagi.foodie.domain.model.Recipe
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Destination
@Composable
fun RecipeDetailsScreen(
    recipeItem : Recipe,
    navigator: DestinationsNavigator
) {
 Scaffold( backgroundColor = Color.White,
           topBar = {
               Row(
                   Modifier
                       .fillMaxWidth()
                       .padding(15.dp),
                   horizontalArrangement = Arrangement.SpaceBetween,
                   verticalAlignment = Alignment.CenterVertically
                   ) {
                   IconButton(onClick = { navigator.popBackStack() }) {
                       Icon(painter = painterResource(id = R.drawable.baseline_left_24),
                           contentDescription = null,
                           modifier = Modifier.size(32.dp)
                           )
                   }
                   IconButton(onClick = { /*TODO*/ }) {
                       Icon(painter = painterResource(id = R.drawable.baseline_no_food_24), contentDescription = null)
                   }
               }
           }
     ){ paddingValues ->  
     Foods(
         recipeItem,
         modifier = Modifier
             .fillMaxSize()
             .padding(paddingValues)
     )
         
     
     
 }
    
}

@Composable
fun Foods(recipeItem: Recipe, modifier: Modifier) {
Column {
    Box(modifier = Modifier.weight(1f), contentAlignment = Alignment.Center) {
        Image(painter = rememberAsyncImagePainter(
            ImageRequest.Builder(LocalContext.current)
                .data(data = recipeItem.image)
                .apply (block = fun ImageRequest.Builder.() {
                    placeholder(R.drawable.baseline_no_food_24)
                    crossfade(true)
                }).build()

        ), contentDescription = null,
            modifier = Modifier
                .fillMaxSize(),
            contentScale = ContentScale.Inside)
    }
    
    Spacer(modifier = Modifier.height(12.dp))
    
    Card(modifier = Modifier
        .fillMaxWidth()
        .weight(1.5f),
        elevation = 1.dp,
        shape = RoundedCornerShape(topEnd = 20.dp, topStart = 20.dp),
        backgroundColor = Color.LightGray
    ) {
        Box(modifier = Modifier.fillMaxWidth()) {
            Column(modifier = Modifier.padding(16.dp),
                verticalArrangement = Arrangement.Top
                ) {
                
                Text(text = recipeItem.title,
                color = Color.Black,
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp
                    )
                Spacer(modifier = Modifier.height(12.dp))
                
                Text(text = recipeItem.imageType)
            }
        }
        
        
    }
    
    
    
}
}

