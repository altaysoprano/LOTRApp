package com.example.lotr.presentation.character_list

import android.util.Log
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.lotr.common.Constants
import com.example.lotr.common.Resource
import com.example.lotr.data.dto.Character
import com.example.lotr.domain.CharacterRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CharacterListViewModel @Inject constructor(
    private val characterRepository: CharacterRepository
) : ViewModel() {

    val state = mutableStateOf(CharacterListState())
    val limit = mutableStateOf(20)
    var recipeListScrollPosition = 0
    val searchTextState: MutableState<String> = mutableStateOf(value = "")

    init {
        searchCharacters("/${searchTextState.value}/i", limit.value, Constants.HEADER)
    }

    private fun getCharacters(limit : Int, header : String) {
        characterRepository.getCharacters(limit, header).onEach { result ->
            when(result) {
                is Resource.Success -> {
                    state.value = CharacterListState(characters = result.data ?: emptyList())
                }
                is Resource.Error -> {
                    state.value = CharacterListState(error = result.message ?: "Unexpected Error")
                }
                is Resource.Loading -> {
                    state.value = CharacterListState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }

    fun searchCharacters(name: String, limit : Int, header : String) {
        characterRepository.searchCharacters(name, limit, header).onEach { result ->
            when(result) {
                is Resource.Success -> {
                    state.value = CharacterListState(characters = result.data ?: emptyList())
                }
                is Resource.Error -> {
                    state.value = CharacterListState(error = result.message ?: "Unexpected Error")
                }
                is Resource.Loading -> {
                    state.value = CharacterListState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }

    private fun incrementLimit() {
        limit.value = limit.value + 20
    }

    fun onChangeRecipeScrollPosition(position: Int){
        recipeListScrollPosition = position
    }

    fun nextPage() {
                incrementLimit()
                characterRepository.getCharacters(limit.value, Constants.HEADER).onEach {result ->
                    when(result) {
                        is Resource.Success -> {
                            state.value = CharacterListState(characters = result.data ?: emptyList())
                        }
                        is Resource.Error -> {
                            state.value = CharacterListState(error = result.message ?: "Unexpected Error")
                        }
                        is Resource.Loading -> {
                            state.value = state.value.copy(isLoading = true)
                        }
                    }
                }.launchIn(viewModelScope)
    }

    fun updateSearchTextState(newValue: String) {
        searchTextState.value = newValue
    }

}