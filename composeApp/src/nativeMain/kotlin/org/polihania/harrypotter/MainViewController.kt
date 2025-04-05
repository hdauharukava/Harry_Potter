package org.polihania.harrypotter

import androidx.compose.ui.window.ComposeUIViewController
import org.polihania.harrypotter.core.di.koinConfiguration

fun MainViewController() = ComposeUIViewController(
    configure = {
        koinConfiguration()
    }
) {
    App()
}