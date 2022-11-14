package com.njagi.foodie.random.model

import com.njagi.foodie.random.DishDto

internal fun DishDto.toDomain(): Dish {

    return Dish(
        aggregateLikes = aggregateLikes,
        cheap =cheap,
         creditsText = creditsText,
    dairyFree = dairyFree,
    dishTypes = dishTypes,
     gaps= gaps,
    glutenFree = glutenFree,
    healthScore = healthScore,
    id = id,
    image =image,
    imageType = imageType,
    instructions = instructions,
    ketogenic = ketogenic,
    license = license,
    lowFodmap = lowFodmap,
    pricePerServing =pricePerServing,
    readyInMinutes = readyInMinutes,
    servings =servings,
    sourceName = sourceName,
    sourceUrl = sourceUrl,
    spoonacularScore = spoonacularScore,
    spoonacularSourceUrl = spoonacularSourceUrl,
    summary = summary,
    sustainable = sustainable,
    title = title,
    vegan=vegan,
    vegetarian = vegetarian,
    veryHealthy = veryHealthy,
    veryPopular = veryPopular,
    weightWatcherSmartPoints = weightWatcherSmartPoints,
    whole30 = whole30
    )
}