package com.njagi.foodie.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.njagi.foodie.feature_category.CategoryState
import com.njagi.foodie.feature_category.CategoryViewModel
import com.njagi.foodie.presentation.common.CategorySection
import com.njagi.foodie.presentation.nav.BottomBar
import com.njagi.foodie.presentation.common.TopAppSection

@Composable
fun HomeScreen() {

    val navcontroller = rememberNavController()
    Scaffold(
        topBar = { TopAppSection()},
        bottomBar = { BottomBar(navHostController = navcontroller) }

    ) { paddingValues ->
    Column(modifier = Modifier
        .padding(paddingValues)
        .fillMaxSize()) {
        FetchCategoryData()
    }

    }
}

@Composable
fun FetchCategoryData(
 categoryVM: CategoryViewModel = viewModel()
)
{
Column(modifier = Modifier
    .padding(10.dp)
    .fillMaxSize()) {
    when(val state = categoryVM.categorystate.collectAsState().value){

        is CategoryState.Empty -> Text(text = "empty")
        is CategoryState.Loading -> Text(text = "Loading ...")
        is CategoryState.Success -> CategorySection(categories = state.data)
        is CategoryState.Error -> Text(text = state.message)
    }

}
}