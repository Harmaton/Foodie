package com.njagi.foodie.data.recipe_dto


import com.google.gson.annotations.SerializedName

data class UnusedIngredient(
    @SerializedName("aisle")
    val aisle: String,
    @SerializedName("amount")
    val amount: Double,
    @SerializedName("id")
    val id: Int,
    @SerializedName("image")
    val image: String,
    @SerializedName("meta")
    val meta: List<Any>,
    @SerializedName("name")
    val name: String,
    @SerializedName("original")
    val original: String,
    @SerializedName("originalName")
    val originalName: String,
    @SerializedName("unit")
    val unit: String,
    @SerializedName("unitLong")
    val unitLong: String,
    @SerializedName("unitShort")
    val unitShort: String
)