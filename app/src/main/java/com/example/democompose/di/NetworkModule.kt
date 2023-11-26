package com.example.democompose.di

import com.example.democompose.network.model.ReceipeDtoMapper
import com.example.democompose.network.model.RecipeDto
import com.example.democompose.network.recipeService.RecipeService
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Named
import javax.inject.Singleton


@InstallIn(SingletonComponent::class)
@Module
class NetworkModule {

    @Singleton
    @Provides
    fun provideRecipeMapper() : ReceipeDtoMapper{
        return ReceipeDtoMapper()
    }

    @Singleton
    @Provides
    fun provideRecipeService() : RecipeService{
        return Retrofit.Builder()
            .baseUrl("https://food2fork.ca/api/recipe/")
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .build()
            .create(RecipeService::class.java)
    }
    @Provides
    @Singleton
    @Named("auth_token")
    fun provideToken() : String{
        return "Token 9c8b06d329136da358c2d00e76946b0111ce2c48"
    }
}