package com.example.democompose.presentation.ui.recipeList

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.democompose.domain.data.data.Recipe
import com.example.democompose.repository.RecipeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Named

@HiltViewModel
class RecipeViewModel
@ViewModelInject
constructor(
   private val repository: RecipeRepository,
   private @Named("auth_token") val token: String
) :ViewModel(){

    /*private val _recipes : MutableLiveData<List<Recipe>> = MutableLiveData()
    private val recipe : LiveData<List<Recipe>> get() = _recipes*/
    val recipe : MutableState<List<Recipe>> = mutableStateOf(listOf())

    init {
        viewModelScope.launch {
           val result = repository.search(
                token = token,
                page = 1,
                query = "chicken"
            )
            recipe.value = result
        }
    }
}