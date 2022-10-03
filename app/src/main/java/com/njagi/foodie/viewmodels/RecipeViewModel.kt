package com.njagi.foodie.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.njagi.foodie.repositories.RecipeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import okio.IOException
import retrofit2.HttpException
import javax.inject.Inject

@HiltViewModel
class RecipeViewModel @Inject constructor(private val recipeRepo: RecipeRepository): ViewModel() {
    private var _recipestate = MutableStateFlow<RecipeState>(RecipeState.Empty)
    val recipestate: StateFlow<RecipeState> = _recipestate

    init {
   getRecipesByIngredients()
    }
    private fun getRecipesByIngredients(){
        _recipestate.value = RecipeState.Loading

        viewModelScope.launch(Dispatchers.IO) {
            try {
                val recipeResponse = recipeRepo.getRecipesIngredients()
                _recipestate.value = RecipeState.Success(recipeResponse)
            }catch (exception: HttpException){
                _recipestate.value = RecipeState.Error("Check Internet")
            }catch (exception: IOException){
                _recipestate.value = RecipeState.Error("Gotta Be a Problem")
            }
        }
    }
}