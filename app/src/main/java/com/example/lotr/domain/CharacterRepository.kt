package com.example.lotr.domain

import com.example.lotr.common.Resource
import com.example.lotr.data.LotrApi
import com.example.lotr.data.dto.CharachterListDtoToCharacterList
import com.example.lotr.data.dto.Character
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class CharacterRepository @Inject constructor(
    private val api : LotrApi
) {

    fun getCharacters(limit : Int, header : String) : Flow<Resource<List<Character>>> = flow {
        try {
            emit(Resource.Loading<List<Character>>())
            val characters = api.getCharacterList(limit, header).CharachterListDtoToCharacterList()
            emit(Resource.Success<List<Character>>(characters))
        }catch (e: HttpException) {
            emit(Resource.Error<List<Character>>("Unexpected Error"))
        }
        catch(e : IOException) {
            emit(Resource.Error<List<Character>>("Please check your internet connection"))
        }

    }
}