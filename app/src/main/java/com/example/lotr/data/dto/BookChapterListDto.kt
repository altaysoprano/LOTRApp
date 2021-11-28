package com.example.lotr.data.dto

data class BookChapterListDto(
    val docs: List<Chapter>,
    val limit: Int,
    val offset: Int,
    val page: Int,
    val pages: Int,
    val total: Int
)

fun BookChapterListDto.BookChapterListDtoToBookChaptersList() : List<Chapter> {
    return docs
}