package com.example.democompose.di

import com.example.democompose.network.model.ReceipeDtoMapper
import com.example.democompose.network.recipeService.RecipeService
import com.example.democompose.repository.RecipeRepository
import com.example.democompose.repository.RecipeRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Provides
    @Singleton
    fun provideRecipe(
        recipeService : RecipeService,
        receipeDtoMapper: ReceipeDtoMapper
    ) : RecipeRepository{
        return RecipeRepositoryImpl(
            recipeService,receipeDtoMapper
        )
    }
}