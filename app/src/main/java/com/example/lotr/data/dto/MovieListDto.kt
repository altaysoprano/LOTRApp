package com.example.lotr.data.dto

data class MovieListDto(
    val docs: List<Movie>,
    val limit: Int,
    val offset: Int,
    val page: Int,
    val pages: Int,
    val total: Int
)

fun MovieListDto.MovieListDtoToMovieList(): List<Movie> {
    val movieList = mutableListOf<Movie>()

    for (movie in docs) {
        if (movie._id == "5cd95395de30eff6ebccde5c" ||
            movie._id == "5cd95395de30eff6ebccde5b" ||
            movie._id == "5cd95395de30eff6ebccde5d"
        ) {
            movieList.add(movie)
        }
    }
    return movieList
}