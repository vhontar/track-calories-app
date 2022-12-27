package com.vhontar.core.util

sealed interface UiEvent {
    object Next: UiEvent
    object Back: UiEvent
    object NavigateUp: UiEvent
    data class ShowSnackbar(val message: UiText): UiEvent
}
