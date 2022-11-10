package com.njagi.foodie.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class RecipeItem(
    val id : Int,
    val image: String,
    val likes :Int,
    val title: String,
    val usedIngredientCount : Int,
    // val usedIngredients :String,//
    val imageType: String,
    val missedIngredientCount: Int,
    // val missedIngredients : String,//
    // val unusedIngredients : String  //


) : Parcelable