package com.njagi.foodie.feature_category


import com.google.gson.annotations.SerializedName

data class Category(

    @SerializedName("categories")
    val categories: List<CategoryX>
)