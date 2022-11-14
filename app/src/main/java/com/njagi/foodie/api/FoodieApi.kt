package com.njagi.foodie.api

import com.njagi.foodie.utils.CONSTANTS
import com.njagi.foodie.data.recipe_dto.Recipes
import com.njagi.foodie.data.recipe_dto.RecipesItem
import com.njagi.foodie.random.DishDto
import retrofit2.http.GET

interface FoodieApi {

    @GET(CONSTANTS.FINDBY_INGREDIENTS_ENDP)
    suspend fun searchRecipeByIngridient(): List<RecipesItem>

    @GET(CONSTANTS.RANDOM_ENDP)
    suspend fun getRandomRecipe() : DishDto


}