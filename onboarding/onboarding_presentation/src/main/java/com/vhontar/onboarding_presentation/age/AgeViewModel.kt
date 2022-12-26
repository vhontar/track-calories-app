package com.vhontar.onboarding_presentation.age

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.viewModelScope
import com.vhontar.core.base.BaseViewModel
import com.vhontar.core.domain.preferences.Preferences
import com.vhontar.core.util.UiEvent
import com.vhontar.core.util.UiText
import com.vhontar.core.R
import com.vhontar.core.navigation.Route
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AgeViewModel @Inject constructor(
    private val preferences: Preferences
) : BaseViewModel() {

    var age by mutableStateOf(loadDefaultAge())
        private set

    val ageRange = 18..120

    fun onAgeEnter(age: Int) {
        this.age = age
    }

    fun onNextClick() = viewModelScope.launch {
        if (!ageRange.contains(age)) {
            _uiEvent.send(
                UiEvent.ShowSnackbar(
                    UiText.StringResource(R.string.error_age_cant_be_empty)
                )
            )
            return@launch
        }

        preferences.saveAge(age)
        _uiEvent.send(UiEvent.Navigate(Route.HEIGHT))
    }

    fun onBackClick() = viewModelScope.launch {
        _uiEvent.send(UiEvent.Navigate(Route.GENDER))
    }

    private fun loadDefaultAge(): Int {
        val age = preferences.loadUserInfo().age
        return if (age == -1) 20 else age
    }
}