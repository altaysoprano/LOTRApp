package com.example.lotr.data.dto

data class Character(
    val _id: String,
    val birth: String,
    val death: String,
    val gender: String,
    val hair: String,
    val height: String,
    val name: String,
    val race: String,
    val realm: String,
    val spouse: String,
    val wikiUrl: String?
)