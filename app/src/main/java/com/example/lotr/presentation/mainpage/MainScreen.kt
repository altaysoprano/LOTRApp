package com.example.lotr.presentation

import android.content.res.Configuration
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.lotr.presentation.mainpage.Section
import com.example.lotr.R
import com.example.lotr.Screen
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun MainScreen(navController: NavController) {
    val configuration = LocalConfiguration.current
    when (configuration.orientation) {
        Configuration.ORIENTATION_LANDSCAPE -> {
            SectionsScreenRotate(navController)
        }
        else -> {
            SectionsScreen(navController)
        }
    }
}

@Composable
fun SectionsScreen(navController: NavController) {
    Column(
        modifier = Modifier.padding(10.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .padding(10.dp)
        ) {
            SectionItem(
                section = Section("Characters", R.drawable.charachtersdraw),
                onItemClick = {navController.navigate(Screen.CharacterListScreen.route)}
            )
        }

        Column(
            modifier = Modifier
                .fillMaxHeight()
                .weight(1f)
                .padding(10.dp)
        ) {
            SectionItem(
                section = Section("Movies", R.drawable.moviesdraw),
                onItemClick = { navController.navigate(Screen.MovieListScreen.route)}
            )
        }
        Column(
            modifier = Modifier
                .fillMaxHeight()
                .weight(1f)
                .padding(10.dp)
        ) {
            SectionItem(
                section = Section("Books", R.drawable.booksdraw),
                onItemClick = { navController.navigate(Screen.BookListScreen.route) }
            )
        }
    }
}

@Composable
fun SectionsScreenRotate(navController: NavController) {
    Row(
        modifier = Modifier.padding(10.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .padding(10.dp)
        ) {
            SectionItem(
                section = Section("Characters", R.drawable.charachtersdraw),
                onItemClick = {navController.navigate(Screen.CharacterListScreen.route)}
            )
        }

        Column(
            modifier = Modifier
                .fillMaxHeight()
                .weight(1f)
                .padding(10.dp)
        ) {
            SectionItem(
                section = Section("Movies", R.drawable.moviesdraw),
                onItemClick = {navController.navigate(Screen.MovieListScreen.route)}
            )
        }
        Column(
            modifier = Modifier
                .fillMaxHeight()
                .weight(1f)
                .padding(10.dp)
        ) {
            SectionItem(
                section = Section("Books", R.drawable.booksdraw),
                onItemClick = { navController.navigate(Screen.BookListScreen.route) }
            )
        }
    }

}

@Composable
fun SectionItem(section: Section, onItemClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxSize()
            .clickable { onItemClick() },
        shape = RoundedCornerShape(15.dp),
        elevation = 5.dp,
    ) {
        Box(modifier = Modifier.fillMaxSize()) {
            Image(
                painter = painterResource(id = section.imageId),
                contentDescription = section.title,
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(12.dp),
                contentAlignment = Alignment.BottomCenter
            ) {
                Text(
                    section.title, style = TextStyle(
                        color = Color.White,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                    )
                )
            }

        }

    }
}













