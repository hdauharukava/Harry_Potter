package org.polihania.harrypotter.feature.spells.domain.repository

import kotlinx.coroutines.flow.Flow
import org.polihania.harrypotter.core.utils.Data
import org.polihania.harrypotter.feature.spells.domain.model.SpellModel

interface SpellRepository {

    fun getSpellsList(): Flow<Data<List<SpellModel>>>

    fun searchSpell(query: String): Flow<Data<List<SpellModel>>>
}