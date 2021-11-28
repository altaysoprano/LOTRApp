package com.example.lotr.presentation.book_list

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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.lotr.data.dto.Book
import com.example.lotr.R

@Composable
fun BookListItem(
    book: Book,
    onItemClick: (Book) -> Unit
) {
    Column(
        modifier = Modifier
            .padding(10.dp)
            .clickable { onItemClick(book) }
    ) {
        Card(
            modifier = Modifier
                .fillMaxSize(),
            shape = RoundedCornerShape(15.dp),
            elevation = 5.dp
            ) {
            Row(modifier = Modifier.fillMaxSize()) {
                Image(
                    painter = painterResource(
                        id = when (book._id) {
                            "5cf5805fb53e011a64671582" -> R.drawable.the_fellowship_of_the_rings
                            "5cf58077b53e011a64671583" -> R.drawable.two_towers
                            "5cf58080b53e011a64671584" -> R.drawable.return_of_the_king
                            else -> R.drawable.transparent_book_background
                        }
                    ),
                    contentDescription = book.name,
                    modifier = Modifier.padding(5.dp)
                )
                Text(
                    modifier = Modifier.padding(5.dp),
                    text = "${book.name}",
                    style = MaterialTheme.typography.h4,
                    overflow = TextOverflow.Ellipsis
                )
            }
        }
    }
}

















