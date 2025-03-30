package org.polihania.harrypotter.core.presentation.base

sealed interface ListScreenIntent {

    data class OnItemClicked(val itemId: Int) : ListScreenIntent

    data object UpdateList : ListScreenIntent
}