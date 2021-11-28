package com.example.lotr.presentation.movie_list

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.lotr.common.Constants
import com.example.lotr.common.Resource
import com.example.lotr.data.dto.Movie
import com.example.lotr.domain.MovieRepository
import com.example.lotr.presentation.book_list.BookListState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class MovieListViewModel @Inject constructor(
    private val movieRepository: MovieRepository
) : ViewModel() {

    val state = mutableStateOf(MovieListState())

    init {
        getMovies(Constants.HEADER).toString()
    }

    private fun getMovies(header: String) {
        movieRepository.getMovies(header).onEach { result ->
            when(result) {
                is Resource.Success -> {
                    state.value = MovieListState(movies = result.data ?: emptyList())
                }
                is Resource.Error -> {
                    state.value = MovieListState(error = result.message ?: "Unexpected Error")
                }
                is Resource.Loading -> {
                    state.value = MovieListState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }

}