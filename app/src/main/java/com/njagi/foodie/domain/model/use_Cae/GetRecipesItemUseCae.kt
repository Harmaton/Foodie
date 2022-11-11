package com.njagi.foodie.domain.model.use_Cae



import com.njagi.foodie.domain.model.Recipe
import com.njagi.foodie.repositories.RecipeRepository
import com.njagi.foodie.utils.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetRecipesItemUseCae @Inject constructor(
    private val RecipesRepository: RecipeRepository
) {
    suspend operator fun invoke(): Flow<Resource<List<Recipe>>> {
        return RecipesRepository.getRecipesByIngredients()
    }
}