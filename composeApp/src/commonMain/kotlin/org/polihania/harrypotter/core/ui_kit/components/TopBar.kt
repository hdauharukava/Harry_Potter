package org.polihania.harrypotter.core.ui_kit.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import org.jetbrains.compose.resources.stringResource
import org.polihania.harrypotter.core.navigation.StartScreenRoute
import org.polihania.harrypotter.core.navigation.normalizeRoute
import org.polihania.harrypotter.feature.main_screen.getTopBarItems

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(navController: NavController) {
    val items = getTopBarItems()
    val navBackStackEntry = navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry.value?.destination?.route

    val currentItem = items.find {
        normalizeRoute(it.route::class.qualifiedName) == normalizeRoute(currentDestination)
    }

    if (normalizeRoute(currentDestination) == normalizeRoute(StartScreenRoute::class.qualifiedName)) {
        return
    }
    TopAppBar(
        modifier = Modifier.shadow(elevation = 4.dp),
        title = {
            currentItem?.let {
                PotterText(
                    text = stringResource(resource = it.title),
                    style = MaterialTheme.typography.displayMedium
                )
            }
        },
        navigationIcon = {
            if (currentItem?.showBackButton == true) {
                IconButton(onClick = { navController.popBackStack() }) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = "Back"
                    )
                }
            }
        }
    )
}

