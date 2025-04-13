package org.polihania.harrypotter.feature.characters.presentation.characters_details

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImagePainter
import coil3.compose.rememberAsyncImagePainter
import harrypotter.composeapp.generated.resources.Res
import harrypotter.composeapp.generated.resources.character_details_birthDate
import harrypotter.composeapp.generated.resources.character_details_children
import harrypotter.composeapp.generated.resources.character_details_hogwartsHouse
import harrypotter.composeapp.generated.resources.character_details_interpretedBy
import org.polihania.harrypotter.core.presentation.base.DetailsScreenIntent
import org.polihania.harrypotter.core.ui_kit.components.DetailsScreenContent
import org.jetbrains.compose.resources.stringResource
import org.polihania.harrypotter.core.ui_kit.components.PotterText

@Composable
fun CharactersDetailsScreen(
    state: CharactersDetailsState,
    onIntent: (DetailsScreenIntent) -> Unit,
) {
    DetailsScreenContent(
        data = state.character,
        onErrorButtonClick = { onIntent(DetailsScreenIntent.UpdateDetailsData) },
        content = { characterDetails ->
            val painter = rememberAsyncImagePainter(characterDetails.image)
            val imageState by painter.state.collectAsState()

            when (imageState) {
                is AsyncImagePainter.State.Empty,
                is AsyncImagePainter.State.Loading -> {
                    CircularProgressIndicator()
                }

                is AsyncImagePainter.State.Success -> {
                    Image(
                        painter = painter,
                        contentDescription = null
                    )
                }

                is AsyncImagePainter.State.Error -> {}
            }

            PotterText(
                modifier = Modifier.padding(vertical = 8.dp).fillMaxWidth(),
                text = characterDetails.fullName,
                style = MaterialTheme.typography.displayLarge,
                color = MaterialTheme.colorScheme.onBackground,
                textAlign = TextAlign.Center
            )

            characterDetails.hogwartsHouse.takeIf { it.isNotEmpty() }?.let {
                Row(
                    Modifier.padding(vertical = 8.dp).fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        modifier = Modifier.weight(1f),
                        text = stringResource(resource = Res.string.character_details_hogwartsHouse),
                        style = MaterialTheme.typography.titleLarge,
                        color = MaterialTheme.colorScheme.onBackground
                    )

                    Text(
                        modifier = Modifier.weight(1f),
                        text = it,
                        style = MaterialTheme.typography.titleLarge,
                        color = MaterialTheme.colorScheme.onSurface
                    )
                }
            }

            characterDetails.birthDate.takeIf { it.isNotEmpty() }?.let {
                Row(
                    Modifier.padding(vertical = 8.dp).fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        modifier = Modifier.weight(1f),
                        text = stringResource(resource = Res.string.character_details_birthDate),
                        style = MaterialTheme.typography.titleLarge,
                        color = MaterialTheme.colorScheme.onBackground
                    )

                    Text(
                        modifier = Modifier.weight(1f),
                        text = it,
                        style = MaterialTheme.typography.titleLarge,
                        color = MaterialTheme.colorScheme.onSurface
                    )
                }
            }

            characterDetails.children.takeIf { it.isNotEmpty() }?.let { list ->
                Row(
                    Modifier.padding(vertical = 8.dp).fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        modifier = Modifier.weight(1f),
                        text = stringResource(resource = Res.string.character_details_children),
                        style = MaterialTheme.typography.titleLarge,
                        color = MaterialTheme.colorScheme.onBackground
                    )
                    Column(modifier = Modifier.weight(1f)) {
                        list.forEach {
                            Text(
                                text = it,
                                style = MaterialTheme.typography.titleLarge,
                                color = MaterialTheme.colorScheme.onSurface
                            )
                        }
                    }
                }
            }

            characterDetails.interpretedBy.takeIf { it.isNotEmpty() }?.let {
                Row(
                    Modifier.padding(vertical = 8.dp).fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        modifier = Modifier.weight(1f),
                        text = stringResource(resource = Res.string.character_details_interpretedBy),
                        style = MaterialTheme.typography.titleLarge,
                        color = MaterialTheme.colorScheme.onBackground
                    )

                    Text(
                        modifier = Modifier.weight(1f),
                        text = it,
                        style = MaterialTheme.typography.titleLarge,
                        color = MaterialTheme.colorScheme.onSurface
                    )
                }
            }
        }
    )
}