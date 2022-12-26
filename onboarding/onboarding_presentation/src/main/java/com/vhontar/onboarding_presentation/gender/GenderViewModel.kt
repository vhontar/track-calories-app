package com.vhontar.onboarding_presentation.gender

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.viewModelScope
import com.vhontar.core.base.BaseViewModel
import com.vhontar.core.domain.models.Gender
import com.vhontar.core.domain.preferences.Preferences
import com.vhontar.core.navigation.Route
import com.vhontar.core.util.UiEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GenderViewModel @Inject constructor(
    private val preferences: Preferences
) : BaseViewModel() {

    var selectedGender by mutableStateOf(preferences.loadUserInfo().gender)
        private set

    fun onGenderClick(gender: Gender) {
        selectedGender = gender
    }

    fun onNextClick() = viewModelScope.launch {
        preferences.saveGender(selectedGender)
        _uiEvent.send(UiEvent.Navigate(Route.AGE))
    }

    fun onBackClick() = viewModelScope.launch {
        _uiEvent.send(UiEvent.Navigate(Route.WELCOME))
    }
}