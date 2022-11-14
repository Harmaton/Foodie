package com.njagi.foodie.repositories




import com.njagi.foodie.domain.model.Recipe
import com.njagi.foodie.random.model.Dish
import com.njagi.foodie.utils.Resource
import kotlinx.coroutines.flow.Flow

interface RecipeRepository{
    suspend fun getRecipesByIngredients() : Flow<Resource<List<Recipe>>>

}