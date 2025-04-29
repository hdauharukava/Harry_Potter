package org.polihania.harrypotter.core.di

import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module
import org.polihania.harrypotter.feature.start.AudioPlayer

actual val platformModule = module {
    singleOf(::AudioPlayer)
}