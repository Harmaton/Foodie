package com.njagi.foodie.domain.model.use_Cae


import com.njagi.foodie.data.recipe_dto.RecipesItem
import com.njagi.foodie.repositories.RecipeRepository
import com.njagi.foodie.utils.Resource
import kotlinx.coroutines.flow.Flow

class GetRecipesItemUseCae(
    private val RecipesRepository: RecipeRepository
) {
    suspend operator fun invoke(): Flow<Resource<ArrayList<RecipesItem>>> {
        return RecipesRepository.getRecipesByIngredients()
    }
}