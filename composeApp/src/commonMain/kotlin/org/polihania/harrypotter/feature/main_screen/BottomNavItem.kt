package org.polihania.harrypotter.feature.main_screen


import androidx.compose.runtime.Immutable
import harrypotter.composeapp.generated.resources.Res
import harrypotter.composeapp.generated.resources.about
import harrypotter.composeapp.generated.resources.books
import harrypotter.composeapp.generated.resources.characters
import harrypotter.composeapp.generated.resources.houses
import harrypotter.composeapp.generated.resources.spells
import org.polihania.harrypotter.core.navigation.BottomNavigationRoutes
import org.jetbrains.compose.resources.StringResource

@Immutable
data class BottomNavItem(
    val route: BottomNavigationRoutes,
    val icon: String,
    val label: StringResource
)

fun getBottomNavItems(): List<BottomNavItem> = listOf(
    BottomNavItem(
        route = BottomNavigationRoutes.BooksList,
        icon = "files/books.svg",
        label = Res.string.books
    ),
    BottomNavItem(
        route = BottomNavigationRoutes.CharactersList,
        icon = "files/chars.svg",
        label = Res.string.characters
    ),
    BottomNavItem(
        route = BottomNavigationRoutes.HousesList,
        icon = "files/houses.svg",
        label = Res.string.houses
    ),
    BottomNavItem(
        route = BottomNavigationRoutes.SpellsList,
        icon = "files/wand.svg",
        label = Res.string.spells
    ),
    BottomNavItem(
        route = BottomNavigationRoutes.About,
        icon = "files/about.svg",
        label = Res.string.about
    )
)