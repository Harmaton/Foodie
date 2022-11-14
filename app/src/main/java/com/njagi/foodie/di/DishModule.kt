package com.njagi.foodie.di

import com.njagi.foodie.api.FoodieApi
import com.njagi.foodie.random.dish_usecase.GetDishUseCase
import com.njagi.foodie.random.repository.DishRepository
import com.njagi.foodie.random.repository.DishRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DishModule {

    @Provides
    @Singleton
    fun providesDishRepository( api: FoodieApi): DishRepository{
        return DishRepositoryImpl(api)
    }

    @Provides
    @Singleton
    fun providesRandomDishUseCase( dishRepository: DishRepository): GetDishUseCase{
        return GetDishUseCase(dishRepository)
    }
}