package com.njagi.foodie.random.repository

import com.njagi.foodie.api.FoodieApi
import com.njagi.foodie.random.model.Dish
import com.njagi.foodie.random.model.toDomain
import com.njagi.foodie.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import okio.IOException
import retrofit2.HttpException
import javax.inject.Inject

class DishRepositoryImpl @Inject constructor (private val api: FoodieApi) : DishRepository {

    override suspend fun getRandomRecipe(): Flow<Resource<Dish>> = flow {

        emit(Resource.Loading())

        try{
            val dishRes = api.getRandomRecipe()

            emit(Resource.Success(dishRes.toDomain() ))

        }
        catch (e : IOException){
            emit(Resource.Error(message = "Please Check your Internet"))
        }
        catch (e : HttpException){
            emit(Resource.Error(message = "OOps, something went wrong"))
        }

    }

}