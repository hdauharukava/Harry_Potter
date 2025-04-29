package org.polihania.harrypotter.feature.main_screen

import androidx.compose.runtime.Immutable
import harrypotter.composeapp.generated.resources.Res
import harrypotter.composeapp.generated.resources.about
import harrypotter.composeapp.generated.resources.book_details
import harrypotter.composeapp.generated.resources.books
import harrypotter.composeapp.generated.resources.character_details
import harrypotter.composeapp.generated.resources.characters
import harrypotter.composeapp.generated.resources.houses
import harrypotter.composeapp.generated.resources.spells
import org.polihania.harrypotter.core.navigation.BottomNavigationRoutes
import org.polihania.harrypotter.core.navigation.DetailsRoutes
import org.polihania.harrypotter.core.navigation.NavigationRoute
import org.jetbrains.compose.resources.StringResource

@Immutable
data class TopBarItem(
    val route: NavigationRoute,
    val title: StringResource,
    val showBackButton: Boolean = false
)

fun getTopBarItems(): List<TopBarItem> {
    return listOf(
        TopBarItem(BottomNavigationRoutes.BooksList, Res.string.books),
        TopBarItem(BottomNavigationRoutes.CharactersList, Res.string.characters),
        TopBarItem(BottomNavigationRoutes.HousesList, Res.string.houses),
        TopBarItem(BottomNavigationRoutes.SpellsList, Res.string.spells),
        TopBarItem(BottomNavigationRoutes.About, Res.string.about),

        TopBarItem(
            DetailsRoutes.BooksDetails(0),
            Res.string.book_details,
            showBackButton = true
        ),
        TopBarItem(
            DetailsRoutes.CharacterDetails(0),
            Res.string.character_details,
            showBackButton = true
        )
    )
}
