package org.polihania.harrypotter.feature.main_screen

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import org.polihania.harrypotter.core.navigation.NavigationGraph
import org.polihania.harrypotter.core.ui_kit.components.BottomBar
import org.polihania.harrypotter.core.ui_kit.components.TopBar

@Composable
fun MainScreen() {
    val navController = rememberNavController()
    Scaffold(
        bottomBar = {
            BottomBar(navController = navController)
        },
        topBar = {
            TopBar(navController = navController)
        }
    ) { paddingValues ->
        NavigationGraph(
            modifier = Modifier.padding(paddingValues),
            navHostController = navController
        )
    }
}