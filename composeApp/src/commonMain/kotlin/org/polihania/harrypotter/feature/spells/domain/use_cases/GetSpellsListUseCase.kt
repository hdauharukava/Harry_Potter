package org.polihania.harrypotter.feature.spells.domain.use_cases

import org.polihania.harrypotter.feature.spells.domain.repository.SpellRepository

class GetSpellsListUseCase(
    private val repository: SpellRepository
) {
    operator fun invoke() = repository.getSpellsList()
}