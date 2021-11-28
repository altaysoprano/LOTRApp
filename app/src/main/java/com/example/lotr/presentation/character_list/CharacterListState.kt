package com.example.lotr.presentation.character_list

import com.example.lotr.data.dto.Character

data class CharacterListState(
    val isLoading : Boolean = false,
    var characters : List<Character> = emptyList(),
    val error : String = ""
)
