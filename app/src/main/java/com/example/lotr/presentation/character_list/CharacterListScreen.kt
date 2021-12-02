package com.example.lotr.presentation.character_list

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.*
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.lotr.common.Constants
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

@Composable
fun CharacterListScreen(
    characterListViewModel: CharacterListViewModel = hiltViewModel()
) {
    val state = characterListViewModel.state.value
    val limit = characterListViewModel.limit.value
    val searchTextState by characterListViewModel.searchTextState

    Scaffold(
        topBar = {
            SearchAppBar(
                text = searchTextState,
                onTextChange = {
                    characterListViewModel.updateSearchTextState(it)
                    Log.d("searchtextstate", it)
                    characterListViewModel.searchCharacters("/${searchTextState}/i", limit, Constants.HEADER)
                },
                onCloseClicked = {},
                onSearchClicked = {characterListViewModel.searchCharacters("/" + searchTextState + "/i", limit, Constants.HEADER)}
            )
        }
    ) {
        Box(modifier = Modifier.fillMaxSize()) {

            val listState = rememberLazyListState()

            LazyColumn(modifier = Modifier.fillMaxSize(), state = listState) {
                itemsIndexed(state.characters) { index, character ->
                    characterListViewModel.onChangeRecipeScrollPosition(index)
                    if ((index + 1) >= limit) {
                        characterListViewModel.nextPage()
                    }
                    CharacterListItem(character = character)
                }
            }

            if (state.error.isNotBlank()) {
                Text(
                    text = state.error,
                    color = MaterialTheme.colors.error,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp)
                        .align(Alignment.Center)
                )
            }
            if (state.isLoading) {
                CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
            }
        }

    }
}