package com.example.lotr.presentation.movie_list

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
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
import com.example.lotr.data.dto.Movie
import com.example.lotr.R
import com.example.lotr.data.dto.Book

@Composable
fun MovieListItem(
    movie: Movie,
    onItemClick: (Movie) -> Unit
) {

    Column(
        modifier = Modifier
            .padding(10.dp)
            .clickable{onItemClick(movie)}
    ) {
        Card(
            modifier = Modifier
                .fillMaxSize(),
            shape = RoundedCornerShape(15.dp),
            elevation = 5.dp
        ) {
            Row(modifier = Modifier.fillMaxSize()) {
                Box(modifier = Modifier.height(200.dp)) {
                    Image(
                        painter = painterResource(
                            id = when (movie._id) {
                                "5cd95395de30eff6ebccde58" -> R.drawable.unexpected_journey_movie
                                "5cd95395de30eff6ebccde59" -> R.drawable.desolation_of_smaug_movie
                                "5cd95395de30eff6ebccde5a" -> R.drawable.battle_of_five_armies_movie
                                "5cd95395de30eff6ebccde5b" -> R.drawable.the_two_towers_movie
                                "5cd95395de30eff6ebccde5c" -> R.drawable.the_fellowship_of_the_ring_movie
                                "5cd95395de30eff6ebccde5d" -> R.drawable.the_return_of_the_king_movie
                                else -> R.drawable.transparent_movie_background
                            }
                        ),
                        contentDescription = movie.name,
                        modifier = Modifier.padding(10.dp)
                    )
                }
                Column(verticalArrangement = Arrangement.spacedBy(1.dp)) {
                    Text(
                        modifier = Modifier.padding(5.dp),
                        text = "${movie.name}",
                        style = MaterialTheme.typography.h4,
                        overflow = TextOverflow.Ellipsis
                    )
                    Row(modifier = Modifier.fillMaxWidth()) {
                        Text(
                            modifier = Modifier.padding(5.dp),
                            text = "Duration: ",
                            style = MaterialTheme.typography.h5,
                            overflow = TextOverflow.Ellipsis
                        )
                        Text(
                            modifier = Modifier.padding(5.dp),
                            text = "${movie.runtimeInMinutes}" + " Minutes",
                            style = MaterialTheme.typography.h6,
                            overflow = TextOverflow.Ellipsis
                        )
                    }
                    Row(modifier = Modifier.fillMaxWidth()) {
                        Text(
                            modifier = Modifier.padding(5.dp),
                            text = "Budget (in millions): ",
                            style = MaterialTheme.typography.h5,
                            overflow = TextOverflow.Ellipsis
                        )
                        Text(
                            modifier = Modifier.padding(5.dp),
                            text = "${movie.budgetInMillions}",
                            style = MaterialTheme.typography.h6,
                            overflow = TextOverflow.Ellipsis
                        )
                    }
                    Row(modifier = Modifier.fillMaxWidth()) {
                        Text(
                            modifier = Modifier.padding(5.dp),
                            text = "Box Office Revenue (in Millions): ",
                            style = MaterialTheme.typography.h5,
                            overflow = TextOverflow.Ellipsis
                        )
                        Text(
                            modifier = Modifier.padding(5.dp),
                            text = "${movie.boxOfficeRevenueInMillions}",
                            style = MaterialTheme.typography.h6,
                            overflow = TextOverflow.Ellipsis
                        )
                    }
                    Row(modifier = Modifier.fillMaxWidth()) {
                        Text(
                            modifier = Modifier.padding(5.dp),
                            text = "Academy Award Nominations: ",
                            style = MaterialTheme.typography.h5,
                            overflow = TextOverflow.Ellipsis
                        )
                        Text(
                            modifier = Modifier.padding(5.dp),
                            text = "${movie.academyAwardNominations}",
                            style = MaterialTheme.typography.h6,
                            overflow = TextOverflow.Ellipsis
                        )
                    }
                    Row(modifier = Modifier.fillMaxWidth()) {
                        Text(
                            modifier = Modifier.padding(5.dp),
                            text = "Academy Award Wins: ",
                            style = MaterialTheme.typography.h5,
                            overflow = TextOverflow.Ellipsis
                        )
                        Text(
                            modifier = Modifier.padding(5.dp),
                            text = "${movie.academyAwardWins}",
                            style = MaterialTheme.typography.h6,
                            overflow = TextOverflow.Ellipsis
                        )
                    }
                    Row(modifier = Modifier.fillMaxWidth()) {
                        Text(
                            modifier = Modifier.padding(5.dp),
                            text = "Rotten Tomatoes Score: ",
                            style = MaterialTheme.typography.h5,
                            overflow = TextOverflow.Ellipsis
                        )
                        Text(
                            modifier = Modifier.padding(5.dp),
                            text = "${movie.rottenTomatoesScore}",
                            style = MaterialTheme.typography.h6,
                            overflow = TextOverflow.Ellipsis
                        )
                    }
                }
            }
        }


        /* {
            Row(modifier = Modifier.fillMaxSize()) {
                Image(
                    painter = painterResource(
                        id = when (movie._id) {
                            "5cd95395de30eff6ebccde58" -> R.drawable.unexpected_journey_movie
                            "5cd95395de30eff6ebccde59" -> R.drawable.desolation_of_smaug_movie
                            "5cd95395de30eff6ebccde5a" -> R.drawable.battle_of_five_armies_movie
                            "5cd95395de30eff6ebccde5b" -> R.drawable.the_two_towers_movie
                            "5cd95395de30eff6ebccde5c" -> R.drawable.the_fellowship_of_the_ring_movie
                            "5cd95395de30eff6ebccde5d" -> R.drawable.the_return_of_the_king_movie
                            else -> R.drawable.transparent_movie_background
                        }
                    ),
                    contentDescription = movie.name,
                    modifier = Modifier.padding(5.dp)
                )
                Column(modifier = Modifier.fillMaxSize()) {
                    Text(
                        modifier = Modifier.padding(5.dp),
                        text = "${movie.name}",
                        style = MaterialTheme.typography.h4,
                        overflow = TextOverflow.Ellipsis
                    )
                    Row(modifier = Modifier.fillMaxWidth()) {
                        Text(
                            modifier = Modifier.padding(5.dp),
                            text = "Duration: ",
                            style = MaterialTheme.typography.h4,
                            overflow = TextOverflow.Ellipsis
                        )
                        Text(
                            modifier = Modifier.padding(5.dp),
                            text = "${movie.runtimeInMinutes}",
                            style = MaterialTheme.typography.h4,
                            overflow = TextOverflow.Ellipsis
                        )
                    }
                    Row(modifier = Modifier.fillMaxWidth()) {
                        Text(
                            modifier = Modifier.padding(5.dp),
                            text = "Budget (In millions): ",
                            style = MaterialTheme.typography.h4,
                            overflow = TextOverflow.Ellipsis
                        )
                        Text(
                            modifier = Modifier.padding(5.dp),
                            text = "${movie.budgetInMillions}",
                            style = MaterialTheme.typography.h4,
                            overflow = TextOverflow.Ellipsis
                        )
                    }
                    Row(modifier = Modifier.fillMaxWidth()) {
                        Text(
                            modifier = Modifier.padding(5.dp),
                            text = "Box Office Revenue (In Millions): ",
                            style = MaterialTheme.typography.h4,
                            overflow = TextOverflow.Ellipsis
                        )
                        Text(
                            modifier = Modifier.padding(5.dp),
                            text = "${movie.boxOfficeRevenueInMillions}",
                            style = MaterialTheme.typography.h4,
                            overflow = TextOverflow.Ellipsis
                        )
                    }
                    Row(modifier = Modifier.fillMaxWidth()) {
                        Text(
                            modifier = Modifier.padding(5.dp),
                            text = "Academy Award Nominations: ",
                            style = MaterialTheme.typography.h4,
                            overflow = TextOverflow.Ellipsis
                        )
                        Text(
                            modifier = Modifier.padding(5.dp),
                            text = "${movie.academyAwardNominations}",
                            style = MaterialTheme.typography.h4,
                            overflow = TextOverflow.Ellipsis
                        )
                    }
                    Row(modifier = Modifier.fillMaxWidth()) {
                        Text(
                            modifier = Modifier.padding(5.dp),
                            text = "Academy Award Wins: ",
                            style = MaterialTheme.typography.h4,
                            overflow = TextOverflow.Ellipsis
                        )
                        Text(
                            modifier = Modifier.padding(5.dp),
                            text = "${movie.academyAwardWins}",
                            style = MaterialTheme.typography.h4,
                            overflow = TextOverflow.Ellipsis
                        )
                    }
                    Row(modifier = Modifier.fillMaxWidth()) {
                        Text(
                            modifier = Modifier.padding(5.dp),
                            text = "Rotten Tomatoes Score: ",
                            style = MaterialTheme.typography.h4,
                            overflow = TextOverflow.Ellipsis
                        )
                        Text(
                            modifier = Modifier.padding(5.dp),
                            text = "${movie.rottenTomatoesScore}",
                            style = MaterialTheme.typography.h4,
                            overflow = TextOverflow.Ellipsis
                        )
                    }
                }
            }
        } */
    }
}