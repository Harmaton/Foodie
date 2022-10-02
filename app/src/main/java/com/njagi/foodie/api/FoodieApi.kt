package com.njagi.foodie.api


import com.njagi.foodie.constants.CONSTANTS.CATEGORIES_ENDPOINT
import com.njagi.foodie.feature_category.Category
import com.njagi.foodie.feature_category.CategoryX
import retrofit2.http.GET

interface FoodieApi {

    @GET(CATEGORIES_ENDPOINT)
    suspend fun getCategories() : Category

}