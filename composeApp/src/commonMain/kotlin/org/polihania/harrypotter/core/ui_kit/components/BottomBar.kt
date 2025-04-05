package org.polihania.harrypotter.core.ui_kit.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import coil3.compose.AsyncImage
import harrypotter.composeapp.generated.resources.Res
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.stringResource
import org.polihania.harrypotter.core.navigation.BottomNavigationRoutes
import org.polihania.harrypotter.core.navigation.normalizeRoute
import org.polihania.harrypotter.feature.main_screen.getBottomNavItems

@OptIn(ExperimentalResourceApi::class)
@Composable
fun BottomBar(navController: NavController) {
    val items = getBottomNavItems()
    val navBackStackEntry = navController.currentBackStackEntryAsState()
    val currentDestination = normalizeRoute(navBackStackEntry.value?.destination?.route)

    val isVisible =
        items.any { normalizeRoute(it.route::class.qualifiedName) == currentDestination }

    AnimatedVisibility(
        visible = isVisible,
        enter = fadeIn(animationSpec = tween(300)),
        exit = fadeOut(animationSpec = tween(300)) + slideOutVertically(animationSpec = tween(300)) { it }
    ) {
        NavigationBar(
            containerColor = MaterialTheme.colorScheme.surface,
            tonalElevation = 4.dp
        ) {
            items.forEach { item ->
                val isSelected =
                    normalizeRoute(currentDestination) == normalizeRoute(item.route::class.qualifiedName)

                NavigationBarItem(
                    selected = isSelected,
                    onClick = {
                        if (!isSelected) {
                            navController.navigate(
                                item.route::class.qualifiedName ?: return@NavigationBarItem
                            ) {
                                popUpTo(BottomNavigationRoutes.BooksList) {
                                    saveState = true
                                }
                                launchSingleTop = true
                                restoreState = true
                            }
                        }
                    },
                    icon = {
                        AsyncImage(
                            model = Res.getUri(item.icon),
                            contentDescription = null,
                            modifier = Modifier.size(24.dp),
                        )
                    },
                    label = {
                        PotterText(
                            text = stringResource(resource = item.label),
                            style = MaterialTheme.typography.titleLarge,
                            color = if (isSelected)
                                MaterialTheme.colorScheme.onPrimary
                            else
                                MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    },
                    colors = NavigationBarItemDefaults.colors(
                        selectedIconColor = MaterialTheme.colorScheme.primary,
                        unselectedIconColor = MaterialTheme.colorScheme.onSurfaceVariant,
                        selectedTextColor = MaterialTheme.colorScheme.primary,
                        unselectedTextColor = MaterialTheme.colorScheme.onSurfaceVariant,
                        indicatorColor = MaterialTheme.colorScheme.primaryContainer,
                    )
                )
            }
        }
    }
}

