package com.example.lotr

sealed class Screen(val route : String){
    object BookListScreen : Screen("book_list")
    object BookChaptersScreen : Screen("book_chapters")
    object MainScreen : Screen("main_screen")
    object MovieListScreen : Screen("movie_list")
    object MovieQuoteListScreen : Screen("movie_quotes")
    object CharacterListScreen : Screen("character_list")
}
