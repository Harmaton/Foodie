package com.njagi.foodie.presentation.nav

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Favorite
import androidx.compose.material.icons.rounded.Home
import androidx.compose.ui.graphics.vector.ImageVector
import com.njagi.foodie.R
import com.njagi.foodie.presentation.destinations.Destination
import com.njagi.foodie.presentation.destinations.FavouritesScreenDestination
import com.njagi.foodie.presentation.destinations.HomeScreenDestination
import com.njagi.foodie.presentation.destinations.MealPlanScreenDestination

sealed class BottomNavItem(var icon: Int, var destination: Destination) {
    object Home : BottomNavItem(
        icon = R.drawable.bs_home_24,
        destination = HomeScreenDestination
    )

    object Favourite : BottomNavItem(
        icon = R.drawable.baseline_favorite_24,
        destination = FavouritesScreenDestination
    )

    object Plan : BottomNavItem(
        icon = R.drawable.bs_next_plan_24,
        destination = MealPlanScreenDestination
    )
}