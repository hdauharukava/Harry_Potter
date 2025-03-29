package org.polihania.harrypotter.core.di

import org.koin.core.context.startKoin
import org.koin.dsl.KoinAppDeclaration
import org.polihania.harrypotter.core.data.di.dataModule
import org.polihania.harrypotter.core.navigation.di.navigationModule
import org.polihania.harrypotter.feature.spells.di.spellsModule

fun koinConfiguration(appDeclaration: KoinAppDeclaration? = null) = startKoin {
    appDeclaration?.invoke(this)

    modules(
        dataModule,
        navigationModule,
        spellsModule,
    )
}
