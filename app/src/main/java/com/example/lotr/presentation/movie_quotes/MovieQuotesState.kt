package com.example.lotr.presentation.movie_quotes

import com.example.lotr.data.dto.Quote

data class MovieQuotesState(
    val isLoading : Boolean = false,
    val quotes : List<Quote> = emptyList(),
    val error : String = ""
)
