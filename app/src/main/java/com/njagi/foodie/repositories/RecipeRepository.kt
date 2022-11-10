package com.njagi.foodie.repositories

import com.njagi.foodie.api.FoodieApi
import com.njagi.foodie.data.recipe_dto.Recipes
import com.njagi.foodie.data.recipe_dto.RecipesItem
import com.njagi.foodie.utils.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

//class RecipeRepository @Inject constructor (private val api: FoodieApi) {
//
//    suspend fun getRecipesIngredients(): Recipes {
//        return api.searchRecipeByIngridient()
//    }
//
//}

interface RecipeRepository{
    suspend fun getRecipesByIngredients() : Flow<Resource<ArrayList<RecipesItem>>>

}