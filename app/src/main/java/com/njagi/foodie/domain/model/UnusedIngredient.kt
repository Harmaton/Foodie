package com.njagi.foodie.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class UnusedIngredient (
    val aisle: String,
    val amount: Double,
    val id: Int,
    val image: String,
    // val meta: List<Any>,
    val name: String,
    val original: String,
    val originalName: String,
    val unit: String,
    val unitLong: String,
    val unitShort: String
        ) : Parcelable