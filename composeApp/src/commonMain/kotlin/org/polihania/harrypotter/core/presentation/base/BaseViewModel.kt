package org.polihania.harrypotter.core.presentation.base

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

abstract class BaseViewModel<STATE, INTENT>(
    initialState: STATE,
) : ViewModel() {

    protected val _state = MutableStateFlow(initialState)
    val state = _state.asStateFlow()

    abstract fun handleIntent(intent: INTENT)

    protected inline fun updateState(state: STATE.() -> STATE) {
        _state.update(state)
    }
}