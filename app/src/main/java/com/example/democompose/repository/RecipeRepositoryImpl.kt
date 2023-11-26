package com.example.democompose.repository

import com.example.democompose.domain.data.data.Recipe
import com.example.democompose.network.model.ReceipeDtoMapper
import com.example.democompose.network.recipeService.RecipeService

class RecipeRepositoryImpl(
    private val recipeService : RecipeService,
    private val mapper : ReceipeDtoMapper
) : RecipeRepository {

    override suspend fun search(token: String, page: Int, query: String): List<Recipe> {
        val result = recipeService.search(token,page,query).recipes
        return mapper.toDomainList(result)
    }

    override suspend fun get(token: String, id: Int): Recipe {
        return mapper.mapToDomainModel(recipeService.get(token,id))
    }
}