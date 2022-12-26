package com.vhontar.onboarding_presentation.height

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vhontar.core.R
import com.vhontar.core.domain.preferences.Preferences
import com.vhontar.core.navigation.Route
import com.vhontar.core.util.UiEvent
import com.vhontar.core.util.UiText
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HeightViewModel @Inject constructor(
    private val preferences: Preferences
) : ViewModel() {

    var height by mutableStateOf(loadDefaultHeight())
        private set

    val heightRange = 120..250

    private val _uiEvent = Channel<UiEvent>()
    val uiEvent = _uiEvent.receiveAsFlow()

    fun onHeightEnter(height: Int) {
        this.height = height
    }

    fun onNextClick() = viewModelScope.launch {
        if (!heightRange.contains(height)) {
            _uiEvent.send(
                UiEvent.ShowSnackbar(
                    UiText.StringResource(R.string.error_height_cant_be_empty)
                )
            )
            return@launch
        }

        preferences.saveHeight(height)
        _uiEvent.send(UiEvent.Navigate(Route.WEIGHT))
    }

    fun onBackClick() = viewModelScope.launch {
        _uiEvent.send(UiEvent.Navigate(Route.AGE))
    }

    private fun loadDefaultHeight(): Int {
        val height = preferences.loadUserInfo().height
        return if (height == -1) 180 else height
    }
}