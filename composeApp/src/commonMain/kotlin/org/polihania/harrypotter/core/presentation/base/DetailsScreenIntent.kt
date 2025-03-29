package org.polihania.harrypotter.core.presentation.base

sealed interface DetailsScreenIntent {

    data object UpdateDetailsData : DetailsScreenIntent
}
