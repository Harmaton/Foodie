package com.njagi.foodie.repositories

import com.njagi.foodie.api.FoodieApi
import com.njagi.foodie.model_recipe.Recipes
import com.njagi.foodie.model_recipe.RecipesItem
import javax.inject.Inject

class RecipeRepository @Inject constructor (private val api: FoodieApi) {
    suspend fun getRecipesIngredients(): Recipes {
        return api.searchRecipeByIngridient()
    }
//
//    suspend fun getRecipesItem() :RecipesItem{
//        return api.getRecipeItem()
//    }
}