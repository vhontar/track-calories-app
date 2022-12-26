package com.vhontar.onboarding_presentation.goaltype

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.viewModelScope
import com.vhontar.core.base.BaseViewModel
import com.vhontar.core.domain.models.GoalType
import com.vhontar.core.domain.preferences.Preferences
import com.vhontar.core.navigation.Route
import com.vhontar.core.util.UiEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GoalTypeViewModel @Inject constructor(
    private val preferences: Preferences
) : BaseViewModel() {

    var selectedGoalType by mutableStateOf<GoalType>(GoalType.KeepWeight)
        private set

    fun onGoalTypeClick(goalType: GoalType) {
        selectedGoalType = goalType
    }

    fun onNextClick() = viewModelScope.launch {
        preferences.saveGoalType(selectedGoalType)
        _uiEvent.send(UiEvent.Navigate(Route.NUTRIENT_GOAL))
    }
}