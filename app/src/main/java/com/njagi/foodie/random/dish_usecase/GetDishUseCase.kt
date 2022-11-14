package com.njagi.foodie.random.dish_usecase

import com.njagi.foodie.domain.model.Recipe
import com.njagi.foodie.random.model.Dish
import com.njagi.foodie.random.repository.DishRepository
import com.njagi.foodie.utils.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetDishUseCase @Inject constructor(
    private val dishRepository: DishRepository
) {

    suspend operator fun invoke(): Flow<Resource<Dish>> {
        return dishRepository.getRandomRecipe()
    }
}