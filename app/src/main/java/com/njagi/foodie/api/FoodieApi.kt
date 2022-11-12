package com.njagi.foodie.api

import com.njagi.foodie.utils.CONSTANTS
import com.njagi.foodie.data.recipe_dto.Recipes
import com.njagi.foodie.data.recipe_dto.RecipesItem
import retrofit2.http.GET

interface FoodieApi {

    @GET(CONSTANTS.FINDBY_INGREDIENTS_ENDP)
    suspend fun searchRecipeByIngridient(): List<RecipesItem>

}