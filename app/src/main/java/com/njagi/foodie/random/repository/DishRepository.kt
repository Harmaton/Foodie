package com.njagi.foodie.random.repository

import com.njagi.foodie.random.model.Dish
import com.njagi.foodie.utils.Resource
import kotlinx.coroutines.flow.Flow

interface DishRepository {

    suspend fun getRandomRecipe(): Flow<Resource<Dish>>
}