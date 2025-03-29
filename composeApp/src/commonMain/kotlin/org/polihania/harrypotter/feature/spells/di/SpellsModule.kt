package org.polihania.harrypotter.feature.spells.di

import org.polihania.harrypotter.feature.spells.data.api.SpellsApi
import org.polihania.harrypotter.feature.spells.data.repository.SpellRepositoryImpl
import org.polihania.harrypotter.feature.spells.domain.repository.SpellRepository
import org.polihania.harrypotter.feature.spells.domain.use_cases.GetSpellsListUseCase
import org.polihania.harrypotter.feature.spells.domain.use_cases.SearchSpellUseCase
import org.polihania.harrypotter.feature.spells.presentation.SpellsViewModel
import org.koin.core.module.dsl.factoryOf
import org.koin.core.module.dsl.singleOf
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.bind
import org.koin.dsl.module

val spellsModule = module {
    singleOf(::SpellsApi)
    factoryOf(::SpellRepositoryImpl).bind<SpellRepository>()
    factoryOf(::GetSpellsListUseCase)
    factoryOf(::SearchSpellUseCase)
    viewModelOf(::SpellsViewModel)
}