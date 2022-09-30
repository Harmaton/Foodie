package com.njagi.foodie.feature_category


    sealed class CategoryState {

        object Empty: CategoryState()
        object Loading: CategoryState()
        class Success(val data: Category): CategoryState()
        class Error(val message: String): CategoryState()

    }