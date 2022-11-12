package com.njagi.foodie.data.recipe_dto.mappers


import com.njagi.foodie.data.recipe_dto.RecipesItem
import com.njagi.foodie.domain.model.Recipe


internal fun  RecipesItem.toDomain() : Recipe {
    return Recipe(
     id = id,
     image= image,
     likes = likes,
     title = title,
     usedIngredientCount = usedIngredientCount,
     imageType = imageType,
     missedIngredientCount = missedIngredientCount,
    // missedIngredients = missedIngredients,
    //unusedIngredients = unusedIngredients
    )
}