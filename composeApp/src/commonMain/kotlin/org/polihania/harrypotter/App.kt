package org.polihania.harrypotter

import androidx.compose.runtime.Composable
import org.polihania.harrypotter.core.ui_kit.foundation.HogwartsHouse
import org.polihania.harrypotter.core.ui_kit.foundation.PotterTheme
import org.polihania.harrypotter.feature.main_screen.MainScreen

@Composable
fun App() {
    PotterTheme(
        house = HogwartsHouse.Ravenclaw,
        darkTheme = true,
    ) {
        MainScreen()
    }
}
