package com.njagi.foodie.data.recipe_dto.repo

import com.njagi.foodie.api.FoodieApi
import com.njagi.foodie.data.recipe_dto.mappers.toDomain
import com.njagi.foodie.domain.model.Recipe
import com.njagi.foodie.repositories.RecipeRepository
import com.njagi.foodie.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import okio.IOException
import retrofit2.HttpException
import javax.inject.Inject

class RecipesRepositoryImpl @Inject constructor(private val api: FoodieApi): RecipeRepository{
    override suspend fun getRecipesByIngredients(): Flow<Resource<List<Recipe>>> = flow{

        emit(Resource.Loading())

        try {
            val response = api.searchRecipeByIngridient()

            emit(Resource.Success(response.map { it.toDomain() }))
        }
        catch (e : IOException){
            emit(Resource.Error(message = "Please Check your Internet"))
        }
        catch (e : HttpException){
            emit(Resource.Error(message = "OOps, something went wrong"))
        }
    }
}