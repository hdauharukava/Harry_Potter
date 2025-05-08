package org.polihania.harrypotter.feature.about

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import harrypotter.composeapp.generated.resources.Res
import harrypotter.composeapp.generated.resources.about_screen_powered_by
import harrypotter.composeapp.generated.resources.about_screen_title
import org.jetbrains.compose.resources.stringResource

@Composable
fun AboutScreen(
    goToLegendary: () -> Unit,
) {
    var clickCount by rememberSaveable { mutableStateOf(0) }

    Column(
        modifier = Modifier.fillMaxSize().padding(horizontal = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            modifier = Modifier.padding(bottom = 16.dp).clickable {
                clickCount++
                if (clickCount == 5) {
                    clickCount = 0
                    goToLegendary()
                }
            },
            text = stringResource(Res.string.about_screen_title),
            style = MaterialTheme.typography.headlineMedium,
            color = MaterialTheme.colorScheme.onBackground,
            textAlign = TextAlign.Center
        )

        Text(
            text = stringResource(
                Res.string.about_screen_powered_by,
                "https://github.com/fedeperin/potterapi"
            ),
            style = MaterialTheme.typography.titleMedium,
            color = MaterialTheme.colorScheme.onBackground,
            textAlign = TextAlign.Center
        )
    }
}
