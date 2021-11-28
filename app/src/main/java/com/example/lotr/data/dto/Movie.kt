package com.example.lotr.data.dto

data class Movie(
    val _id: String,
    val academyAwardNominations: Int,
    val academyAwardWins: Int,
    val boxOfficeRevenueInMillions: Float,
    val budgetInMillions: Int,
    val name: String,
    val rottenTomatoesScore: Float,
    val runtimeInMinutes: Int
)