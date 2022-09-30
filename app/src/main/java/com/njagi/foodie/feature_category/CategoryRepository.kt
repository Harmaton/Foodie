package com.njagi.foodie.feature_category

import com.njagi.foodie.api.FoodieApi
import com.njagi.foodie.feature_category.Category
import javax.inject.Inject

class CategoryRepository @Inject constructor(private val api: FoodieApi) {

    suspend fun getAllCategories(): Category {
        return api.getCategories()

    }
}