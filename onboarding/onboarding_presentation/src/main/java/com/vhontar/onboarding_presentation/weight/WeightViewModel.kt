package com.vhontar.onboarding_presentation.weight

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.viewModelScope
import com.vhontar.core.R
import com.vhontar.core.base.BaseViewModel
import com.vhontar.core.domain.preferences.Preferences
import com.vhontar.core.navigation.Route
import com.vhontar.core.util.UiEvent
import com.vhontar.core.util.UiText
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WeightViewModel @Inject constructor(
    private val preferences: Preferences
) : BaseViewModel() {

    var weight by mutableStateOf(80)
        private set

    val weightRange = 30..250

    fun onWeightEnter(weight: Int) {
        this.weight = weight
    }

    fun onNextClick() = viewModelScope.launch {
        if (!weightRange.contains(weight)) {
            _uiEvent.send(
                UiEvent.ShowSnackbar(
                    UiText.StringResource(R.string.error_weight_cant_be_empty)
                )
            )
            return@launch
        }

        preferences.saveWeight(weight)
        _uiEvent.send(UiEvent.Navigate(Route.ACTIVITY))
    }
}