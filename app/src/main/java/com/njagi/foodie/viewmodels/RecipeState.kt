package com.njagi.foodie.viewmodels

import com.njagi.foodie.model_recipe.Recipes

sealed class RecipeState{
    object Empty: RecipeState()
    object Loading: RecipeState()
    class Success(val data: Recipes): RecipeState()
    class Error(val message: String): RecipeState()
}
