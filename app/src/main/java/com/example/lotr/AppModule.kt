package com.example.lotr

import com.example.lotr.common.Constants
import com.example.lotr.data.LotrApi
import com.example.lotr.domain.BookRepository
import com.example.lotr.domain.MovieRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun getLotrApi() : LotrApi {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(LotrApi::class.java)
    }

    @Provides
    @Singleton
    fun getBookRepository(api: LotrApi) : BookRepository {
        return BookRepository(api)
    }

    @Provides
    @Singleton
    fun getMovieRepository(api : LotrApi) : MovieRepository {
        return MovieRepository(api)
    }


}













