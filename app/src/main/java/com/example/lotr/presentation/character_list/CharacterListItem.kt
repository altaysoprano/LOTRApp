package com.example.lotr.presentation.character_list

import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.*
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lotr.data.dto.Character

@Composable
fun CharacterListItem(
    character: Character
) {
    Column(modifier = Modifier.padding(10.dp)) {
        Card(
            modifier = Modifier
                .fillMaxSize(),
            shape = RoundedCornerShape(15.dp),
            elevation = 5.dp
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(10.dp)
                    .align(Alignment.CenterHorizontally)
            ) {
                Text(
                    text = "${character.name}",
                    style = MaterialTheme.typography.h4,
                    overflow = TextOverflow.Ellipsis
                )
                Row(modifier = Modifier.fillMaxWidth()) {
                    Text(
                        modifier = Modifier.padding(5.dp),
                        text = "Race: ",
                        style = MaterialTheme.typography.h5,
                        overflow = TextOverflow.Ellipsis
                    )
                    Text(
                        modifier = Modifier.padding(5.dp),
                        text = "${character.race}",
                        style = MaterialTheme.typography.h6,
                        overflow = TextOverflow.Ellipsis
                    )
                }
                Row(modifier = Modifier.fillMaxWidth()) {
                    Text(
                        modifier = Modifier.padding(5.dp),
                        text = "Gender: ",
                        style = MaterialTheme.typography.h5,
                        overflow = TextOverflow.Ellipsis
                    )
                    Text(
                        modifier = Modifier.padding(5.dp),
                        text = "${character.gender}",
                        style = MaterialTheme.typography.h6,
                        overflow = TextOverflow.Ellipsis
                    )
                }
                Row(modifier = Modifier.fillMaxWidth()) {
                    Text(
                        modifier = Modifier.padding(5.dp),
                        text = "Birth: ",
                        style = MaterialTheme.typography.h5,
                        overflow = TextOverflow.Ellipsis
                    )
                    Text(
                        modifier = Modifier.padding(5.dp),
                        text = "${character.birth}",
                        style = MaterialTheme.typography.h6,
                        overflow = TextOverflow.Ellipsis
                    )
                }
                Row(modifier = Modifier.fillMaxWidth()) {
                    Text(
                        modifier = Modifier.padding(5.dp),
                        text = "Gender: ",
                        style = MaterialTheme.typography.h5,
                        overflow = TextOverflow.Ellipsis
                    )
                    Text(
                        modifier = Modifier.padding(5.dp),
                        text = "${character.gender}",
                        style = MaterialTheme.typography.h6,
                        overflow = TextOverflow.Ellipsis
                    )
                }
                Row(modifier = Modifier.fillMaxWidth()) {
                    Text(
                        modifier = Modifier.padding(5.dp),
                        text = "Spouse: ",
                        style = MaterialTheme.typography.h5,
                        overflow = TextOverflow.Ellipsis
                    )
                    Text(
                        modifier = Modifier.padding(5.dp),
                        text = "${character.spouse}",
                        style = MaterialTheme.typography.h6,
                        overflow = TextOverflow.Ellipsis
                    )
                }
                Row(modifier = Modifier.fillMaxWidth()) {
                    Text(
                        modifier = Modifier.padding(5.dp),
                        text = "Death: ",
                        style = MaterialTheme.typography.h5,
                        overflow = TextOverflow.Ellipsis
                    )
                    Text(
                        modifier = Modifier.padding(5.dp),
                        text = "${character.death}",
                        style = MaterialTheme.typography.h6,
                        overflow = TextOverflow.Ellipsis
                    )
                }
                Row(modifier = Modifier.fillMaxWidth()) {
                    Text(
                        modifier = Modifier.padding(5.dp),
                        text = "Realm: ",
                        style = MaterialTheme.typography.h5,
                        overflow = TextOverflow.Ellipsis
                    )
                    Text(
                        modifier = Modifier.padding(5.dp),
                        text = "${character.realm}",
                        style = MaterialTheme.typography.h6,
                        overflow = TextOverflow.Ellipsis
                    )
                }
                Row(modifier = Modifier.fillMaxWidth()) {
                    Text(
                        modifier = Modifier.padding(5.dp),
                        text = "Hair: ",
                        style = MaterialTheme.typography.h5,
                        overflow = TextOverflow.Ellipsis
                    )
                    Text(
                        modifier = Modifier.padding(5.dp),
                        text = "${character.hair}",
                        style = MaterialTheme.typography.h6,
                        overflow = TextOverflow.Ellipsis
                    )
                }
                Row(modifier = Modifier.fillMaxWidth()) {
                    Text(
                        modifier = Modifier.padding(5.dp),
                        text = "Wiki Url: ",
                        style = MaterialTheme.typography.h5,
                        overflow = TextOverflow.Ellipsis
                    )
                    AnnotatedClickableText(character.wikiUrl)
                }
            }
        }
    }
}

@Composable
fun AnnotatedClickableText(wikiUrl: String) {
    val annotatedText = buildAnnotatedString {

        // We attach this *URL* annotation to the following content
        // until `pop()` is called
        pushStringAnnotation(
            tag = "URL",
            annotation = wikiUrl
        )

        append(wikiUrl)

        pop()
    }

    val uriHandler = LocalUriHandler.current

    ClickableText(
        text = annotatedText,
        style = MaterialTheme.typography.h6,
        onClick = { offset ->
            // We check if there is an *URL* annotation attached to the text
            // at the clicked position
            annotatedText.getStringAnnotations(
                tag = "URL", start = offset,
                end = offset
            )
                .firstOrNull()?.let { annotation ->
                    // If yes, we log its value
                    uriHandler.openUri(annotation.item)
                }
        }
    )
}

