package com.example.lotr.presentation.book_chapters

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.lotr.common.Constants
import com.example.lotr.common.Resource
import com.example.lotr.domain.BookRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class BookChaptersViewModel @Inject constructor(
    private val bookRepository: BookRepository,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    val state = mutableStateOf(BookChaptersState())

    init {
        savedStateHandle.get<String>(Constants.PARAM_BOOK_ID)?.let { bookId ->
            getChapters(bookId = bookId)
        }
    }

    fun getChapters(bookId: String) {
        bookRepository.getBookChapters(bookId = bookId).onEach { result ->
            when (result) {
                is Resource.Success -> {
                    state.value = BookChaptersState(chapters = result.data ?: emptyList())
                }
                is Resource.Error -> {
                    state.value = BookChaptersState(error = result.message ?: "Unexpected Error")
                }
                is Resource.Loading -> {
                    state.value = BookChaptersState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }

}