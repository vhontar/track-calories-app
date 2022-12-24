package com.vhontar.trackcaloriesapp.navigation

import androidx.navigation.NavController
import com.vhontar.core.util.UiEvent

fun NavController.navigate(event: UiEvent.Navigate) {
    this.navigate(event.route)
}