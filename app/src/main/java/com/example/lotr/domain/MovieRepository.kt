package com.example.lotr.domain

import android.util.Log
import com.example.lotr.common.Resource
import com.example.lotr.data.LotrApi
import com.example.lotr.data.dto.Movie
import com.example.lotr.data.dto.MovieListDtoToMovieList
import com.example.lotr.data.dto.MovieQuoteListDtoToMovieQuoteList
import com.example.lotr.data.dto.Quote
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class MovieRepository @Inject constructor(
    private val api: LotrApi
) {
    fun getMovies(header: String): Flow<Resource<List<Movie>>> = flow {
        try {
            emit(Resource.Loading<List<Movie>>())
            val movies = api.getMovieList(header).MovieListDtoToMovieList()
            emit(Resource.Success<List<Movie>>(movies))
        } catch (e: HttpException) {
            emit(Resource.Error<List<Movie>>("Unexpected Error"))
        } catch (e: IOException) {
            emit(Resource.Error<List<Movie>>("Please check your internet connection"))
        }
    }

    fun getMovieQuotes(id: String, header: String): Flow<Resource<List<Quote>>> = flow {
        try {
            emit(Resource.Loading<List<Quote>>())
            val quotes = api.getMovieQuoteList(id, header).MovieQuoteListDtoToMovieQuoteList()
            emit(Resource.Success<List<Quote>>(quotes))
        } catch (e: HttpException) {
            emit(Resource.Error<List<Quote>>("Unexpected Error"))
        } catch (e: IOException) {
            emit(Resource.Error<List<Quote>>("Please check your internet conection"))
        }
    }
}