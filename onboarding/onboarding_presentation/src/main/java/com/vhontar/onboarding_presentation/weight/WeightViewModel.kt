package com.vhontar.onboarding_presentation.weight

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vhontar.core.R
import com.vhontar.core.domain.preferences.Preferences
import com.vhontar.core.util.UiEvent
import com.vhontar.core.util.UiText
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WeightViewModel @Inject constructor(
    private val preferences: Preferences
) : ViewModel() {

    var weight by mutableStateOf(loadDefaultWeight())
        private set

    val weightRange = 30..250

    private val _uiEvent = Channel<UiEvent>()
    val uiEvent = _uiEvent.receiveAsFlow()

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
        _uiEvent.send(UiEvent.Next)
    }

    fun onBackClick() = viewModelScope.launch {
        _uiEvent.send(UiEvent.Back)
    }

    private fun loadDefaultWeight(): Int {
        val weight = preferences.loadUserInfo().weight
        return if (weight == -1) 80 else weight
    }
}