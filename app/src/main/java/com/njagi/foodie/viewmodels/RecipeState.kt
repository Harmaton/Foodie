package com.njagi.foodie.viewmodels


import com.njagi.foodie.data.recipe_dto.RecipesItem
import com.njagi.foodie.domain.model.RecipeItem



data class RecipeState(
    val recipeItems: List<RecipesItem> = emptyList(),
    val isLoading: Boolean = true,
    val error: String? = null
)



