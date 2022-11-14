package com.njagi.foodie.viewmodels


import com.njagi.foodie.random.model.Dish

data class DishState(
    val dish: Dish? = null,
    val isLoading: Boolean = true,
    val error: String? = null
)
