package com.njagi.foodie.viewmodels


import com.njagi.foodie.model_recipe.RecipesItem

sealed class RecipeItemstate{
    object Empty: RecipeItemstate()
    object Loading: RecipeItemstate()
    class Success(val data: RecipesItem): RecipeItemstate()
    class Error(val message: String): RecipeItemstate()
}