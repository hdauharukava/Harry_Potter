package org.polihania.harrypotter.core.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.toRoute
import org.koin.compose.koinInject
import org.koin.compose.viewmodel.koinViewModel
import org.koin.core.parameter.parametersOf
import org.polihania.harrypotter.feature.about.AboutScreen
import org.polihania.harrypotter.feature.books.presentation.books_details.BooksDetailsScreen
import org.polihania.harrypotter.feature.books.presentation.books_details.BooksDetailsViewModel
import org.polihania.harrypotter.feature.books.presentation.books_list.BooksListScreen
import org.polihania.harrypotter.feature.books.presentation.books_list.BooksListViewModel
import org.polihania.harrypotter.feature.characters.presentation.characters_details.CharactersDetailsScreen
import org.polihania.harrypotter.feature.characters.presentation.characters_details.CharactersDetailsViewModel
import org.polihania.harrypotter.feature.characters.presentation.characters_list.CharactersListScreen
import org.polihania.harrypotter.feature.characters.presentation.characters_list.CharactersListViewModel
import org.polihania.harrypotter.feature.houses.presentation.HousesScreen
import org.polihania.harrypotter.feature.houses.presentation.HousesViewModel
import org.polihania.harrypotter.feature.main_screen.MainScreen
import org.polihania.harrypotter.feature.spells.presentation.SpellsScreen
import org.polihania.harrypotter.feature.spells.presentation.SpellsViewModel
import org.polihania.harrypotter.feature.start.StartScreen

@Composable
fun NavigationGraph(
    navHostController: NavHostController,
    modifier: Modifier = Modifier,
) {
    val navigation: Navigation = koinInject()

    navigation.setNavigationController(navHostController)

    NavHost(
        modifier = modifier,
        navController = navHostController,
        startDestination = StartScreenRoute
    ) {
        composable<StartScreenRoute> {
            StartScreen(
                onClick = { navigation.navigateToMainScreen() }
            )
        }

        navigation<MainScreenNavRoute>(
            startDestination = BottomNavigationRoutes.BooksList
        ) {
            composable<BottomNavigationRoutes.BooksList> {
                val viewModel: BooksListViewModel = koinViewModel()
                val state by viewModel.state.collectAsStateWithLifecycle()

                BooksListScreen(
                    state = state,
                    onIntent = viewModel::handleIntent
                )

            }

            composable<DetailsRoutes.BooksDetails> {
                val id = it.toRoute<DetailsRoutes.BooksDetails>().bookId
                val viewModel: BooksDetailsViewModel = koinViewModel { parametersOf(id) }
                val state by viewModel.state.collectAsStateWithLifecycle()

                BooksDetailsScreen(
                    state = state,
                    onIntent = viewModel::handleIntent
                )
            }

            composable<BottomNavigationRoutes.CharactersList> {
                val viewModel: CharactersListViewModel = koinViewModel()
                val state by viewModel.state.collectAsStateWithLifecycle()

                CharactersListScreen(
                    state = state,
                    onIntent = viewModel::handleIntent
                )
            }

            composable<DetailsRoutes.CharacterDetails> {
                val id = it.toRoute<DetailsRoutes.CharacterDetails>().characterId
                val viewModel: CharactersDetailsViewModel = koinViewModel { parametersOf(id) }
                val state by viewModel.state.collectAsStateWithLifecycle()

                CharactersDetailsScreen(
                    state = state,
                    onIntent = viewModel::handleIntent
                )
            }

            composable<BottomNavigationRoutes.HousesList> {
                val viewModel: HousesViewModel = koinViewModel()
                val state by viewModel.state.collectAsStateWithLifecycle()

                HousesScreen(
                    state = state,
                    onIntent = viewModel::handleIntent
                )
            }

            composable<BottomNavigationRoutes.SpellsList> {
                val viewModel: SpellsViewModel = koinViewModel()
                val state by viewModel.state.collectAsStateWithLifecycle()

                SpellsScreen(
                    state = state,
                    onIntent = viewModel::handleIntent
                )
            }

            composable<BottomNavigationRoutes.About> {
                AboutScreen()
            }
        }
    }
}
