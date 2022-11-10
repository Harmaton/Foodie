package com.njagi.foodie.data.recipe_dto.mappers


import com.njagi.foodie.data.recipe_dto.RecipesItem


internal fun RecipesItem.toDomain(): RecipesItem {
    return RecipesItem(
     id = id,
     image= image,
     likes = likes,
     title = title,
     usedIngredientCount = usedIngredientCount,
     usedIngredients = usedIngredients,
     imageType = imageType,
     missedIngredientCount = missedIngredientCount,
     missedIngredients = missedIngredients,
     unusedIngredients = unusedIngredients
    )
}