package com.njagi.foodie.viewmodels

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.njagi.foodie.random.dish_usecase.GetDishUseCase
import com.njagi.foodie.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RandomDishViewModel @Inject constructor(private val getDishUseCase: GetDishUseCase): ViewModel() {

    private var _dishstate = mutableStateOf(DishState())
    val dish_state: State<DishState> = _dishstate

    init{
       getTheRandomDish()
    }

    private fun getTheRandomDish() {
        viewModelScope.launch {
            getDishUseCase().collectLatest {dish ->
                when(dish){
                    is Resource.Success -> {
                        _dishstate.value = dish_state.value.copy(
                            dish = dish.data , isLoading = false
                        )

                    }
                    is Resource.Loading -> {

                        _dishstate.value = dish_state.value.copy(
                            isLoading = true
                        )
                    }
                    is Resource.Error-> {
                        _dishstate.value = dish_state.value.copy(
                            isLoading = false,
                            error = dish.message
                        )

                    }
                }

            }
        }

    }


}