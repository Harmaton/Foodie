package com.njagi.foodie.repositories



import com.njagi.foodie.data.recipe_dto.RecipesItem
import com.njagi.foodie.domain.model.RecipeItem
import com.njagi.foodie.utils.Resource
import kotlinx.coroutines.flow.Flow


//class RecipeRepository @Inject constructor (private val api: FoodieApi) {
//
//    suspend fun getRecipesIngredients(): Recipes {
//        return api.searchRecipeByIngridient()
//    }
//
//}

interface RecipeRepository{
    suspend fun getRecipesByIngredients() : Flow<Resource<List<RecipesItem>>>

}