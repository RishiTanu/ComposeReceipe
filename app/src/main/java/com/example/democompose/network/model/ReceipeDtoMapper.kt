package com.example.democompose.network.model

import com.example.democompose.domain.data.data.Recipe
import com.example.democompose.domain.util.DomainMapper

class ReceipeDtoMapper : DomainMapper<RecipeDto,Recipe>{
    override fun mapToDomainModel(model: RecipeDto): Recipe {
        return Recipe(
            id = model.pk,
            title = model.title,
            featuredImage = model.featuredImage,
            rating = model.rating,
            publisher = model.publisher,
            sourceUrl = model.sourceUrl,
            description = model.description,
            cookingInstructions = model.cookingInstructions,
            ingredients = model.ingredients,
            dateAdded = model.dateAdded,
            dateUpdated = model.dateUpdated,
        )
    }

    override fun mapFromDomainModel(domainModel: Recipe): RecipeDto {
        return RecipeDto(
            pk = domainModel.id,
            title = domainModel.title,
            featuredImage = domainModel.featuredImage,
            rating = domainModel.rating,
            publisher = domainModel.publisher,
            sourceUrl = domainModel.sourceUrl,
            description = domainModel.description,
            cookingInstructions = domainModel.cookingInstructions,
            ingredients = domainModel.ingredients,
            dateAdded = domainModel.dateAdded,
            dateUpdated = domainModel.dateUpdated,
        )
    }

    fun toDomainList(initial : List<RecipeDto>) : List<Recipe>{
        return initial.map {
            mapToDomainModel(it)
        }
    }

    fun  fromDomainList(initial: List<Recipe>) : List<RecipeDto>{
        return initial.map { mapFromDomainModel(it) }
    }
}