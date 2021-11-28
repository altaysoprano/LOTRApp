package com.example.lotr.data

import com.example.lotr.data.dto.*
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path
import retrofit2.http.Query

interface LotrApi {

    @GET("book")
    suspend fun getBookList(): BookListDto

    @GET("book/{id}/chapter")
    suspend fun getBookChapterList(
        @Path("id") id : String
    ): BookChapterListDto

    @GET("movie")
    suspend fun getMovieList(
        @Header("Authorization") authHeader : String
    ): MovieListDto

    @GET("movie/{id}/quote")
    suspend fun getMovieQuoteList(
        @Path("id") id : String,
        @Header("Authorization") authHeader : String
    ): MovieQuoteListDto

    @GET("character")
    suspend fun getCharacterList(
        @Query("limit") limit : Int,
        @Header("Authorization") authHeader : String
    ): CharacterListDto
}