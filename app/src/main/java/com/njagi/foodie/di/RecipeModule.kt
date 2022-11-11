package com.njagi.foodie.di

import com.njagi.foodie.api.FoodieApi
import com.njagi.foodie.data.recipe_dto.repo.RecipesRepositoryImpl
import com.njagi.foodie.domain.model.use_Cae.GetRecipesItemUseCae
import com.njagi.foodie.repositories.RecipeRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RecipeModule {

    @Provides
    @Singleton
    fun provieRecipeRepository(
        foodieApi: FoodieApi
    ) : RecipeRepository{
        return RecipesRepositoryImpl(
            foodieApi
        )
    }


    @Provides
    @Singleton
    fun provideRecipeUseCase(recipeRepository: RecipeRepository): GetRecipesItemUseCae{
        return GetRecipesItemUseCae(recipeRepository)
    }
}