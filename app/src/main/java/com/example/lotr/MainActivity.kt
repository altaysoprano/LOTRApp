package com.example.lotr

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.lotr.presentation.*
import com.example.lotr.presentation.book_chapters.BookChaptersScreen
import com.example.lotr.presentation.book_list.BookListScreen
import com.example.lotr.presentation.character_list.CharacterListScreen
import com.example.lotr.presentation.movie_list.MovieListScreen
import com.example.lotr.presentation.movie_quotes.MovieQuotesScreen
import com.example.lotr.ui.theme.LOTRTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @ExperimentalFoundationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LOTRTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = Screen.MainScreen.route
                    ) {
                        composable(
                            route = Screen.MainScreen.route
                        ) {
                            MainScreen(navController)
                        }
                        composable(
                            route = Screen.BookListScreen.route
                        ) {
                            BookListScreen(navController)
                        }
                        composable(
                            route = Screen.BookChaptersScreen.route + "/{bookId}"
                        ){
                            BookChaptersScreen()
                        }
                        composable(
                            route = Screen.MovieListScreen.route
                        ) {
                            MovieListScreen(navController)
                        }
                        composable(
                            route = Screen.MovieQuoteListScreen.route + "/{movieId}"
                        ) {
                            MovieQuotesScreen()
                        }
                        composable(
                            route = Screen.CharacterListScreen.route
                        ){
                            CharacterListScreen()
                        }
                    }

                }
            }
        }
    }
}