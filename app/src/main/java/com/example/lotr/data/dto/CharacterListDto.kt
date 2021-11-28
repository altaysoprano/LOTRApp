package com.example.lotr.data.dto

data class CharacterListDto(
    val docs: List<Character>,
    val limit: Int,
    val offset: Int,
    val page: Int,
    val pages: Int,
    val total: Int
)

fun CharacterListDto.CharachterListDtoToCharacterList(): List<Character> {
    return docs
}