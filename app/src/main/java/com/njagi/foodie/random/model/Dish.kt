package com.njagi.foodie.random.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import com.njagi.foodie.random.ExtendedIngredient
import com.njagi.foodie.random.WinePairing
import kotlinx.parcelize.Parcelize

@Parcelize
data class Dish (
    val aggregateLikes: Int,
   // val analyzedInstructions: List<Any>,
    val cheap: Boolean,
    val creditsText: String,
   // val cuisines: List<Any>,
    val dairyFree: Boolean,
   // val diets: List<Any>,
    val dishTypes: List<String>,
   // val extendedIngredients: List<ExtendedIngredient>,
    val gaps: String,
    val glutenFree: Boolean,
    val healthScore: Double,
    val id: Int,
    val image: String,
    val imageType: String,
    val instructions: String,
    val ketogenic: Boolean,
    val license: String,
    val lowFodmap: Boolean,
   // val occasions: List<Any>,
    val pricePerServing: Double,
    val readyInMinutes: Int,
    val servings: Int,
    val sourceName: String,
    val sourceUrl: String,
    val spoonacularScore: Double,
    val spoonacularSourceUrl: String,
    val summary: String,
    val sustainable: Boolean,
    val title: String,
    val vegan: Boolean,
    val vegetarian: Boolean,
    val veryHealthy: Boolean,
    val veryPopular: Boolean,
    val weightWatcherSmartPoints: Int,
    val whole30: Boolean,
    // val winePairing: WinePairing

        ) : Parcelable
