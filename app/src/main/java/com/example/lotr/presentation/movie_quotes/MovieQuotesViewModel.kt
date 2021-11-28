package com.example.lotr.presentation.movie_quotes

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.lotr.common.Constants
import com.example.lotr.common.Resource
import com.example.lotr.domain.MovieRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class MovieQuotesViewModel @Inject constructor(
    private val movieRepository: MovieRepository,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    val state = mutableStateOf(MovieQuotesState())

    init {
        savedStateHandle.get<String>(Constants.PARAM_MOVIE_ID)?.let { movieId ->
            getMovieQuotes(id = movieId, Constants.HEADER)
        }
    }

    fun getMovieQuotes(id : String, header : String) {
        movieRepository.getMovieQuotes(id, header).onEach { result ->
            when(result) {
                is Resource.Success -> {
                    state.value = MovieQuotesState(quotes = result.data ?: emptyList())
                }
                is Resource.Error -> {
                    state.value = MovieQuotesState(error = result.message ?: "Unexpected Error")
                }
                is Resource.Loading -> {
                    state.value = MovieQuotesState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}