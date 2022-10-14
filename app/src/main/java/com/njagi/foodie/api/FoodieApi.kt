package com.njagi.foodie.api

import com.njagi.foodie.utils.CONSTANTS
import com.njagi.foodie.model_recipe.Recipes
import com.njagi.foodie.model_recipe.RecipesItem
import retrofit2.http.GET

interface FoodieApi {

    @GET(CONSTANTS.FINDBY_INGREDIENTS_ENDP)
    suspend fun searchRecipeByIngridient(): Recipes

    @GET(CONSTANTS.FINDBY_INGREDIENTS_ENDP)
    suspend fun getRecipeItem(): RecipesItem
}