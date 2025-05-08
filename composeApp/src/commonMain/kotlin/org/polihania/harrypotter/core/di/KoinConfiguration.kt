package org.polihania.harrypotter.core.di

import org.koin.core.context.startKoin
import org.koin.dsl.KoinAppDeclaration
import org.polihania.harrypotter.core.data.di.dataModule
import org.polihania.harrypotter.core.navigation.di.navigationModule
import org.polihania.harrypotter.feature.books.di.booksModule
import org.polihania.harrypotter.feature.houses.di.housesModule
import org.polihania.harrypotter.feature.spells.di.spellsModule
import org.polihania.harrypotter.feature.characters.di.charactersModule

fun koinConfiguration(appDeclaration: KoinAppDeclaration? = null) = startKoin {
    appDeclaration?.invoke(this)

    modules(
        dataModule,
        navigationModule,
        booksModule,
        housesModule,
        spellsModule,
        charactersModule,
        platformModule
    )
}
