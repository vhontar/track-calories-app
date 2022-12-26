package com.vhontar.core.util

sealed interface UiEvent {
    data class Navigate(val route: String): UiEvent
    object NavigateUp: UiEvent
    data class ShowSnackbar(val message: UiText): UiEvent
}