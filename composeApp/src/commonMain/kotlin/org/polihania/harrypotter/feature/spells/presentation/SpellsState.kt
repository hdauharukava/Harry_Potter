package org.polihania.harrypotter.feature.spells.presentation

import androidx.compose.runtime.Stable
import org.polihania.harrypotter.core.utils.Data
import org.polihania.harrypotter.feature.spells.domain.model.SpellModel

@Stable
data class SpellsState(
    val spells: Data<List<SpellModel>> = Data.Empty,
)