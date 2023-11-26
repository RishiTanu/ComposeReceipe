package com.example.democompose.repository

import com.example.democompose.domain.data.data.Recipe

interface RecipeRepository {
    suspend fun search(token : String,page:Int,query : String) : List<Recipe>

    suspend fun get(token : String,id:Int) : Recipe
}