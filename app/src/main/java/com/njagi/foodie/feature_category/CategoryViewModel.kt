package com.njagi.foodie.feature_category

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import okio.IOException
import retrofit2.HttpException
import javax.inject.Inject

@HiltViewModel
class CategoryViewModel @Inject constructor(private val categoryRepo: CategoryRepository) :ViewModel() {

    private var _categorystate = MutableStateFlow<CategoryState>(CategoryState.Empty)
    val categorystate: StateFlow<CategoryState> = _categorystate

    init {
        fetchCategories()

    }

    private fun fetchCategories(){
        _categorystate.value = CategoryState.Loading
        viewModelScope.launch(Dispatchers.IO) {
           try {
               val categoryResponse = categoryRepo.getAllCategories()
               _categorystate.value = CategoryState.Success(categoryResponse)

           }
           catch (ex: HttpException){
               _categorystate.value = CategoryState.Error("Check your Connection")

           }
           catch (ex: IOException){
               _categorystate.value = CategoryState.Error("Check your Problem")
           }
            catch (ex: IllegalStateException){
                _categorystate.value = CategoryState.Error("Check the state returned")
            }

        }
    }

}