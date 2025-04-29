package org.polihania.harrypotter.core.navigation

import kotlinx.serialization.Serializable

interface NavigationRoute

@Serializable
sealed interface DetailsRoutes : NavigationRoute {

    @Serializable
    data class BooksDetails(val bookId: Int? = null) : DetailsRoutes

    @Serializable
    data class CharacterDetails(val characterId: Int) : DetailsRoutes
}

@Serializable
sealed interface BottomNavigationRoutes : NavigationRoute {
    @Serializable
    data object BooksList : BottomNavigationRoutes

    @Serializable
    data object CharactersList : BottomNavigationRoutes

    @Serializable
    data object HousesList : BottomNavigationRoutes

    @Serializable
    data object SpellsList : BottomNavigationRoutes

    @Serializable
    data object About : BottomNavigationRoutes
}

@Serializable
data object StartScreenRoute : NavigationRoute

@Serializable
data object MainScreenNavRoute: NavigationRoute

fun normalizeRoute(route: String?): String? {
    return route
        ?.substringBefore("?")
        ?.substringBefore("/")
        ?.substringAfterLast(".")
}
