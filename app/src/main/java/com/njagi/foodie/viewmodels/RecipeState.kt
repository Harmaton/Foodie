package com.njagi.foodie.viewmodels


import com.njagi.foodie.domain.model.Recipe




data class RecipeState(
    val recipeItems: List<Recipe> = emptyList(),
    val isLoading: Boolean = true,
    val error: String? = null
)



