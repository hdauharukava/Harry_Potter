package org.polihania.harrypotter.feature.spells.domain.use_cases

import org.polihania.harrypotter.feature.spells.domain.repository.SpellRepository

class SearchSpellUseCase(
    private val repository: SpellRepository
) {
    operator fun invoke(query: String) = repository.searchSpell(query)
}