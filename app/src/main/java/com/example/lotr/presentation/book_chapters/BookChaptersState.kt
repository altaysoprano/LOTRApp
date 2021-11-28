package com.example.lotr.presentation.book_chapters

import com.example.lotr.common.Resource
import com.example.lotr.data.dto.Chapter

data class BookChaptersState(
    val isLoading: Boolean = false,
    val chapters: List<Chapter> = emptyList(),
    val error: String = ""
)
