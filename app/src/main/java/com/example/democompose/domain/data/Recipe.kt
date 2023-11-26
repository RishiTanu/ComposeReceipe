package com.example.democompose.domain.data.data

data class Recipe (
    var id: Int,
    var title: String,
    var publisher: String,
    var featuredImage: String,
    var rating: Int = 0,
    var sourceUrl: String,
    var description: String,
    var cookingInstructions: String,
    var ingredients: List<String> = listOf(),
    var dateAdded: String,
    var dateUpdated: String
)