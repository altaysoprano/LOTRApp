package com.example.lotr.presentation.movie_list

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.lotr.R
import com.example.lotr.data.dto.Movie

@Composable
fun TrilogyListItem(
    movie: Movie
) {

    Column(
        modifier = Modifier.padding(10.dp)
    ) {
        Card(
            modifier = Modifier
                .fillMaxSize(),
            shape = RoundedCornerShape(15.dp),
            elevation = 5.dp
        ) {
            Box(modifier = Modifier.height(200.dp)) {
                Image(
                    painter = painterResource(
                        id = when (movie._id) {
                            "5cd95395de30eff6ebccde56" -> R.drawable.lotr_trilogy_movie
                            "5cd95395de30eff6ebccde57" -> R.drawable.hobbit_trilogy_poster
                            else -> R.drawable.transparent_movie_background
                        }
                    ),
                    contentDescription = movie.name,
                    modifier = Modifier.padding(10.dp)
                )
            }
        }
    }
}