package com.vhontar.onboarding_presentation.age

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vhontar.core.domain.preferences.Preferences
import com.vhontar.core.util.UiEvent
import com.vhontar.core.util.UiText
import com.vhontar.core.R
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AgeViewModel @Inject constructor(
    private val preferences: Preferences
) : ViewModel() {

    var age by mutableStateOf(loadDefaultAge())
        private set

    val ageRange = 18..120

    private val _uiEvent = Channel<UiEvent>()
    val uiEvent = _uiEvent.receiveAsFlow()

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
        _uiEvent.send(UiEvent.Next)
    }

    fun onBackClick() = viewModelScope.launch {
        _uiEvent.send(UiEvent.Back)
    }

    private fun loadDefaultAge(): Int {
        val age = preferences.loadUserInfo().age
        return if (age == -1) 20 else age
    }
}