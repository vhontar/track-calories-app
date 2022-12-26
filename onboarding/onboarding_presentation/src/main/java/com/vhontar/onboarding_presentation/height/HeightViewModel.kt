package com.vhontar.onboarding_presentation.height

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.viewModelScope
import com.vhontar.core.R
import com.vhontar.core.base.BaseViewModel
import com.vhontar.core.domain.preferences.Preferences
import com.vhontar.core.domain.usecase.FilterOutDigitsUseCase
import com.vhontar.core.navigation.Route
import com.vhontar.core.util.UiEvent
import com.vhontar.core.util.UiText
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HeightViewModel @Inject constructor(
    private val preferences: Preferences,
    private val filterOutDigits: FilterOutDigitsUseCase
) : BaseViewModel() {

    var height by mutableStateOf("180")
        private set

    fun onHeightEnter(height: String) {
        if (height.length in 2..3) {
            this.height = filterOutDigits(height)
        }
    }

    fun onNextClick() = viewModelScope.launch {
        val heightNumber = height.toIntOrNull() ?: kotlin.run {
            _uiEvent.send(
                UiEvent.ShowSnackbar(
                    UiText.StringResource(R.string.error_height_cant_be_empty)
                )
            )
            return@launch
        }

        preferences.saveHeight(heightNumber)
        _uiEvent.send(UiEvent.Navigate(Route.WEIGHT))
    }
}