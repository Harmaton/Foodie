package com.njagi.foodie.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.njagi.foodie.presentation.common.HeaderText
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
        Column(
            modifier = Modifier
                .fillMaxSize().background(Color.LightGray),
            verticalArrangement = Arrangement.spacedBy(15.dp)
        ) {

            TopAppSection()

            HeaderText(text = "Apple Recipes")

            when (val state = recipeViewModel.recipestate.collectAsState().value) {

                is RecipeState.Empty -> Text(text = "Empty")
                is RecipeState.Loading -> Text(text = "Loading ...")
                is RecipeState.Success -> Column() {
                    RecipeSection(recipes = state.data)
                }
                is RecipeState.Error -> Text(text = state.message)


            }

        }
    }

