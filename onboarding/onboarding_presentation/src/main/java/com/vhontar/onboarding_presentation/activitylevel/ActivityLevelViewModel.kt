package com.vhontar.onboarding_presentation.activitylevel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.viewModelScope
import com.vhontar.core.base.BaseViewModel
import com.vhontar.core.domain.models.ActivityLevel
import com.vhontar.core.domain.preferences.Preferences
import com.vhontar.core.navigation.Route
import com.vhontar.core.util.UiEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ActivityLevelViewModel @Inject constructor(
    private val preferences: Preferences
) : BaseViewModel() {

    var selectedActivityLevel by mutableStateOf(preferences.loadUserInfo().activityLevel)
        private set

    fun onActivityLevelClick(activityLevel: ActivityLevel) {
        selectedActivityLevel = activityLevel
    }

    fun onNextClick() = viewModelScope.launch {
        preferences.saveActivityLevel(selectedActivityLevel)
        _uiEvent.send(UiEvent.Navigate(Route.GOAL))
    }

    fun onBackClick() = viewModelScope.launch {
        _uiEvent.send(UiEvent.Navigate(Route.WEIGHT))
    }
}