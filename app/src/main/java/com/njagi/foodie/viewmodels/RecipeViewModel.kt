package com.njagi.foodie.viewmodels

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.njagi.foodie.domain.model.use_Cae.GetRecipesItemUseCae
import com.njagi.foodie.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RecipeViewModel @Inject constructor(private val getRecipesItemUseCae: GetRecipesItemUseCae) :
    ViewModel() {


    private var _recipestate = mutableStateOf(RecipeState())
    val recipe_state: State<RecipeState> = _recipestate

    private val _eventFlow = MutableSharedFlow<UiEvents>()
    val eventFlow: SharedFlow<UiEvents> = _eventFlow.asSharedFlow()

    init {
        getRecipesByIngredients()

    }

    private fun getRecipesByIngredients() {
        viewModelScope.launch {
            getRecipesItemUseCae().collectLatest { result ->
                when (result) {
                    is Resource.Success -> {
                        _recipestate.value = recipe_state.value.copy(
                            recipeItems = result.data ?: emptyList(), isLoading = false
                        )
                    }

                    is Resource.Loading -> {
                        _recipestate.value = recipe_state.value.copy(
                            isLoading = true
                        )

                    }

                    is Resource.Error -> {
                         _recipestate.value = recipe_state.value.copy(
                             isLoading = false,
                             error = result.message
                         )

                        _eventFlow.emit(
                            UiEvents.SnackbarEvent(
                                message = result.message ?: "Unknown error occurred!"
                            )
                        )
                    }


                }

            }
        }


    }
}