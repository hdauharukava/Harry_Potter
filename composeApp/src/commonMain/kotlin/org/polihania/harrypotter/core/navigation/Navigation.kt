package org.polihania.harrypotter.core.navigation

import androidx.navigation.NavController
import androidx.navigation.NavHostController
import org.polihania.harrypotter.core.utils.ifNotNull

interface Navigation {
    fun setNavigationController(navigationController: NavHostController)

    fun navigateToBookDetails(bookId: Int)
    fun navigateToCharacterDetails(characterId: Int)

    fun navigateToMainScreen()
}

class NavigationImpl : Navigation {
    private var navController: NavController? = null

    override fun setNavigationController(navigationController: NavHostController) {
        this.navController = navigationController
    }

    override fun navigateToBookDetails(bookId: Int) {
        navController.ifNotNull {
            it.navigate(DetailsRoutes.BooksDetails(bookId))
        }
    }

    override fun navigateToCharacterDetails(characterId: Int) {
        navController.ifNotNull {
            it.navigate(DetailsRoutes.CharacterDetails(characterId))
        }
    }

    override fun navigateToMainScreen() {
        navController.ifNotNull {
            it.navigate(MainScreenNavRoute)
        }
    }
}
