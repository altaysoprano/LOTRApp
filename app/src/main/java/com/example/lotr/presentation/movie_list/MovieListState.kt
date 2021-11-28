package com.example.lotr.presentation.movie_list

import com.example.lotr.data.dto.Book
import com.example.lotr.data.dto.Movie

data class MovieListState(
    val isLoading: Boolean = false,
    val movies: List<Movie> = emptyList(),
    val error: String = ""
)
