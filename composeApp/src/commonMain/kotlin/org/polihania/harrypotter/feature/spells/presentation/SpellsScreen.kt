package org.polihania.harrypotter.feature.spells.presentation

import androidx.compose.runtime.Composable
import harrypotter.composeapp.generated.resources.Res
import harrypotter.composeapp.generated.resources.spell_item_description_title
import harrypotter.composeapp.generated.resources.spell_item_label_title
import org.polihania.harrypotter.core.presentation.base.ListScreenIntent
import org.polihania.harrypotter.core.ui_kit.components.LazyColumnItem
import org.polihania.harrypotter.core.ui_kit.components.ListScreenContent
import org.jetbrains.compose.resources.stringResource

@Composable
fun SpellsScreen(
    state: SpellsState,
    onIntent: (ListScreenIntent) -> Unit,
) {
    ListScreenContent(
        data = state.spells,
        onErrorButtonClick = { onIntent(ListScreenIntent.UpdateList) },
    ) { spells ->
        LazyColumnItem(
            label = spells.spell,
            labelTitle = stringResource(resource = Res.string.spell_item_label_title),
            description = spells.description,
            descriptionTitle = stringResource(resource = Res.string.spell_item_description_title),
        )
    }
}