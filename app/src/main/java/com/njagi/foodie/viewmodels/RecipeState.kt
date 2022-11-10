package com.njagi.foodie.viewmodels

import com.njagi.foodie.data.recipe_dto.Recipes
import com.njagi.foodie.domain.model.RecipesItem
import com.njagi.foodie.utils.Resource


data class RecipeState(
    val recipeItems: List<RecipesItem>,
    val isLoading: Boolean = true,
    val error: String? = null
)


//    )
//    object Empty: RecipeState()
//    object Loading: RecipeState()
//    class Success(val data: Recipes): RecipeState()
//    class Error(val message: String): RecipeState()
//}
