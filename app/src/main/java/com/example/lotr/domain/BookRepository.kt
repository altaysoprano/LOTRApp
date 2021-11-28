package com.example.lotr.domain

import android.util.Log
import com.example.lotr.common.Resource
import com.example.lotr.data.LotrApi
import com.example.lotr.data.dto.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class BookRepository @Inject constructor(
    private val api : LotrApi
){

    fun getBooks() : Flow<Resource<List<Book>>> = flow {
        try {
            emit(Resource.Loading<List<Book>>())
            val books = api.getBookList().BookListDtoToBookList()
            emit(Resource.Success<List<Book>>(books))
        }
        catch (e: HttpException) {
            emit(Resource.Error<List<Book>>("Unexpected Error"))
        }
        catch(e: IOException) {
            emit(Resource.Error<List<Book>>("Please check your internet connection"))
        }
    }

    fun getBookChapters(bookId : String) : Flow<Resource<List<Chapter>>> = flow {
        try {
            emit(Resource.Loading<List<Chapter>>())
            val chapters = api.getBookChapterList(bookId).BookChapterListDtoToBookChaptersList()
            emit(Resource.Success<List<Chapter>>(chapters))
        }
        catch (e: HttpException) {
            emit(Resource.Error<List<Chapter>>("Unexpected Error"))
        }
        catch(e: IOException) {
            emit(Resource.Error<List<Chapter>>("Please check your internet connection"))
        }
    }

}