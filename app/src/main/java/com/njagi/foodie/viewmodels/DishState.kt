package com.njagi.foodie.viewmodels


import com.njagi.foodie.random.model.Dish

data class DishState(
    val dishes: List<Dish> = emptyList(),
    val isLoading: Boolean = true,
    val error: String? = null
)
