package com.example.lotr.presentation.book_list

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.lotr.common.Resource
import com.example.lotr.domain.BookRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class BookListViewModel @Inject constructor(
    private val bookRepository: BookRepository
) : ViewModel(){

    val state = mutableStateOf(BookListState())

    init {
        getBooks()
    }

    private fun getBooks() {
        bookRepository.getBooks().onEach { result ->
            when(result) {
                is Resource.Success -> {
                    state.value = BookListState(books = result.data ?: emptyList())
                }
                is Resource.Error -> {
                    state.value = BookListState(error = result.message ?: "Unexpected Error")
                }
                is Resource.Loading -> {
                    state.value = BookListState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }

}