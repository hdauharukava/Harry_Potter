package org.polihania.harrypotter.feature.spells.data.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import org.polihania.harrypotter.core.utils.Data
import org.polihania.harrypotter.core.utils.map
import org.polihania.harrypotter.feature.spells.data.api.SpellsApi
import org.polihania.harrypotter.feature.spells.data.dto.toModelList
import org.polihania.harrypotter.feature.spells.domain.model.SpellModel
import org.polihania.harrypotter.feature.spells.domain.repository.SpellRepository

class SpellRepositoryImpl(
    private val api: SpellsApi
) : SpellRepository {
    override fun getSpellsList(): Flow<Data<List<SpellModel>>> {
        return api.getSpells().map {
            it.map { data ->
                data.toModelList()
            }
        }
    }

    override fun searchSpell(query: String): Flow<Data<List<SpellModel>>> {
        return api.getSpells(
            search = query
        ).map {
            it.map { data ->
                data.toModelList()
            }
        }
    }
}