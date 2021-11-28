package com.example.lotr.data.dto

data class MovieQuoteListDto(
    val docs: List<Quote>,
    val limit: Int,
    val offset: Int,
    val page: Int,
    val pages: Int,
    val total: Int
)

fun MovieQuoteListDto.MovieQuoteListDtoToMovieQuoteList() : List<Quote> {
    return docs
}