package com.example.lotr.presentation.book_list

import com.example.lotr.data.dto.Book

data class BookListState(
    val isLoading: Boolean = false,
    val books: List<Book> = emptyList(),
    val error: String = ""
)
