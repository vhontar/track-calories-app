package com.vhontar.onboarding_presentation.age

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.viewModelScope
import com.vhontar.core.base.BaseViewModel
import com.vhontar.core.domain.preferences.Preferences
import com.vhontar.core.domain.usecase.FilterOutDigitsUseCase
import com.vhontar.core.util.UiEvent
import com.vhontar.core.util.UiText
import com.vhontar.core.R
import com.vhontar.core.navigation.Route
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AgeViewModel @Inject constructor(
    private val preferences: Preferences,
    private val filterOutDigits: FilterOutDigitsUseCase
) : BaseViewModel() {

    var age by mutableStateOf("20")
        private set

    fun onAgeEnter(age: String) {
        if (age.length in 1..3) {
            this.age = filterOutDigits(age)
        }
    }

    fun onNextClick() = viewModelScope.launch {
        val ageNumber = age.toIntOrNull() ?: kotlin.run {
            _uiEvent.send(
                UiEvent.ShowSnackbar(
                    UiText.StringResource(R.string.error_age_cant_be_empty)
                )
            )
            return@launch
        }

        preferences.saveAge(ageNumber)
        _uiEvent.send(UiEvent.Navigate(Route.HEIGHT))
    }
}