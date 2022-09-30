package com.njagi.foodie.presentation.nav

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Favorite
import androidx.compose.material.icons.rounded.Home
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomBarScreen(
    val route: String,
    val title: String,
    val icon: ImageVector
) {
    object Home: BottomBarScreen(
        "home",
        "Home",
        Icons.Rounded.Home
    )

    object Favourite: BottomBarScreen(
        "favourite",
        "Favourite",
        Icons.Rounded.Favorite
    )

}