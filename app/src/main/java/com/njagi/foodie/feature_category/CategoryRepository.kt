package com.njagi.foodie.feature_category

import com.njagi.foodie.api.FoodieApi
import javax.inject.Inject

class CategoryRepository @Inject constructor(private val api: FoodieApi) {
    suspend fun getAllCategories(): List<Category>{
        return api.getCategories()
    }
}