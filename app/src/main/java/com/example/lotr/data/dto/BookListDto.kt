package com.example.lotr.data.dto

data class BookListDto(
    val docs: List<Book>,
    val limit: Int,
    val offset: Int,
    val page: Int,
    val pages: Int,
    val total: Int
)

fun BookListDto.BookListDtoToBookList() : List<Book>{
    return docs
}