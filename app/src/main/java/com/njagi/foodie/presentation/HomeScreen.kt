package com.njagi.foodie.presentation

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.base.R
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.njagi.foodie.domain.model.Recipe
import com.njagi.foodie.presentation.common.HeaderText
import com.njagi.foodie.presentation.common.RandomCard
import com.njagi.foodie.presentation.common.SearchInputBox
import com.njagi.foodie.presentation.common.TopAppSection
import com.njagi.foodie.presentation.destinations.RecipeDetailsScreenDestination
import com.njagi.foodie.ui.theme.FoodieTheme
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
    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(5.dp),
        topBar = {TopAppSection()}
    ) { padding ->


        SearchInputBox()
        Spacer(modifier = Modifier.height(10.dp))
        HeaderText(text = "Apple + Flour Recipes")
        Spacer(modifier = Modifier
            .height(5.dp)
            .padding(padding))


        val recipesState = recipeViewModel.recipe_state.value


        Box(modifier = Modifier.fillMaxWidth() ) {
            LazyRow(
                modifier = Modifier
                    .height(200.dp)
                    .padding(top = 1.dp),
                contentPadding = PaddingValues(10.dp),
                horizontalArrangement = Arrangement.spacedBy(20.dp)
            ) {
               items(recipesState.recipeItems){ recipe ->

                  RecipeItemCard(recipeItem = recipe , navigator = navigator)
               }
            }
        }
    }
}


@Composable
 fun RecipeItemCard(
    recipeItem: Recipe,
    navigator: DestinationsNavigator
) {
    Box(
        modifier = Modifier
            .width(200.dp)
            .height(200.dp)
            .background(Color.LightGray),
        propagateMinConstraints = true
    ) {
        Card(
            modifier = Modifier
                .height(150.dp)
                .fillMaxWidth()
                .clickable {
                    // am trying to navigate to the details screen here
                    navigator.navigate(RecipeDetailsScreenDestination(recipeItem))
                },
            border = BorderStroke(1.dp, Color.Black)
        ) {
            Column {
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
                    contentScale = ContentScale.Crop
                )
            }

            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = recipeItem.title,
                maxLines = 2,
                fontSize = 16.sp,
                fontWeight = FontWeight.SemiBold
            )

            Spacer(modifier = Modifier.height(4.dp))

            //likes badge

        }
    }
}

@Composable
@Preview(showBackground = true)
fun HomeScreenPreview(){
    FoodieTheme {
        Column {
            TopAppSection()
            SearchInputBox()
            Spacer(modifier = Modifier.height(6.dp))
            RandomCard()
            HeaderText(text = "Vegeterian")
        }

    }
}

