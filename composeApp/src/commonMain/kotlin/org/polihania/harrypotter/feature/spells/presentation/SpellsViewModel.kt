package org.polihania.harrypotter.feature.spells.presentation

import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import org.polihania.harrypotter.core.presentation.base.BaseViewModel
import org.polihania.harrypotter.core.presentation.base.ListScreenIntent
import org.polihania.harrypotter.feature.spells.domain.use_cases.GetSpellsListUseCase
import org.polihania.harrypotter.feature.spells.domain.use_cases.SearchSpellUseCase

class SpellsViewModel(
    private val getSpellsListUseCase: GetSpellsListUseCase,
    private val searchSpellUseCase: SearchSpellUseCase
) : BaseViewModel<SpellsState, ListScreenIntent>(SpellsState()) {

    init {
        getSpellsList()
    }

    override fun handleIntent(intent: ListScreenIntent) {
        when (intent) {
            is ListScreenIntent.OnItemClicked -> {
                // TODO: Handle item click
            }

            is ListScreenIntent.Search -> searchCharacter(intent.query)
            is ListScreenIntent.UpdateList -> getSpellsList()
        }
    }

    private fun getSpellsList() {
        viewModelScope.launch {
            getSpellsListUseCase().collectLatest { spells ->
                updateState {
                    copy(spells = spells)
                }
            }
        }
    }

    private fun searchCharacter(query: String) {
        viewModelScope.launch {
            searchSpellUseCase(query).collectLatest { spells ->
                updateState {
                    copy(spells = spells)
                }
            }
        }
    }
}