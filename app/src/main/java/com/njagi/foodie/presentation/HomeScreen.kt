package com.njagi.foodie.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.njagi.foodie.presentation.nav.BottomBar
import com.njagi.foodie.presentation.common.TopAppSection

@Composable
fun HomeScreen() {

    val navcontroller = rememberNavController()
    Scaffold(
        topBar = { TopAppSection()},
        bottomBar = { BottomBar(navHostController = navcontroller) }

    ) { paddingValues ->
    Column(modifier = Modifier.padding(paddingValues).fillMaxSize()) {


    }

    }
}