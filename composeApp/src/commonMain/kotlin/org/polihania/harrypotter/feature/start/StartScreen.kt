package org.polihania.harrypotter.feature.start

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import harrypotter.composeapp.generated.resources.Res
import harrypotter.composeapp.generated.resources.start_screen_button
import harrypotter.composeapp.generated.resources.start_screen_description
import harrypotter.composeapp.generated.resources.start_screen_title
import org.jetbrains.compose.resources.stringResource
import org.polihania.harrypotter.core.ui_kit.components.PotterText

@Composable
fun StartScreen(
    onClick: () -> Unit,
) {

    Column(
        modifier = Modifier.fillMaxSize().padding(horizontal = 16.dp, vertical = 8.dp),
    ) {
        Column(
            modifier = Modifier.weight(1f).fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            PotterText(
                text = stringResource(Res.string.start_screen_title),
                style = MaterialTheme.typography.displayLarge,
                color = MaterialTheme.colorScheme.onBackground,
                textAlign = TextAlign.Center
            )
            PotterText(
                text = stringResource(Res.string.start_screen_description),
                style = MaterialTheme.typography.displayMedium,
                color = MaterialTheme.colorScheme.onBackground,
                textAlign = TextAlign.Center
            )
        }

        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = onClick,
        ) {
            PotterText(
                text = stringResource(Res.string.start_screen_button),
                style = MaterialTheme.typography.displaySmall,
                color = MaterialTheme.colorScheme.onBackground,
                textAlign = TextAlign.Justify
            )
        }
    }
}
