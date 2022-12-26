package com.vhontar.onboarding_presentation.nutrientgoal

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vhontar.core.domain.preferences.Preferences
import com.vhontar.core.domain.usecase.FilterOutDigitsUseCase
import com.vhontar.core.navigation.Route
import com.vhontar.core.util.UiEvent
import com.vhontar.onboarding_domain.usecase.ValidateNutrientsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NutrientGoalViewModel @Inject constructor(
    private val preferences: Preferences,
    private val filterOutDigits: FilterOutDigitsUseCase,
    private val validateNutrients: ValidateNutrientsUseCase
): ViewModel() {

    var state by mutableStateOf(loadDefaultNutrientsAsState())
        private set

    private val _uiEvent = Channel<UiEvent>()
    val uiEvent = _uiEvent.receiveAsFlow()

    fun onEvent(event: NutrientGoalEvent) {
        when(event) {
            is NutrientGoalEvent.OnCarbRatioEnter -> {
                state = state.copy(
                    carbsRatioAsText = filterOutDigits(event.ratio)
                )
            }
            is NutrientGoalEvent.OnProteinRatioEnter -> {
                state = state.copy(
                    proteinRatioAsText = filterOutDigits(event.ratio)
                )
            }
            is NutrientGoalEvent.OnFatRatioEnter -> {
                state = state.copy(
                    fatRatioAsText = filterOutDigits(event.ratio)
                )
            }
            is NutrientGoalEvent.OnNextClick -> {
                val result = validateNutrients(
                    carbsRatioText = state.carbsRatioAsText,
                    proteinRatioText = state.proteinRatioAsText,
                    fatRatioText = state.fatRatioAsText
                )

                when(result) {
                    is ValidateNutrientsUseCase.Result.Success -> {
                        preferences.saveCarbRatio(result.carbsRatio)
                        preferences.saveProteinRatio(result.proteinRatio)
                        preferences.saveFatRatio(result.fatRatio)

                        viewModelScope.launch {
                            _uiEvent.send(UiEvent.Navigate(Route.TRACKER_OVERVIEW))
                        }
                    }
                    is ValidateNutrientsUseCase.Result.Error -> {
                        viewModelScope.launch {
                            _uiEvent.send(UiEvent.ShowSnackbar(result.message))
                        }
                    }
                }
            }
            is NutrientGoalEvent.OnBackClick -> {
                viewModelScope.launch {
                    _uiEvent.send(UiEvent.Navigate(Route.GOAL))
                }
            }
        }
    }

    private fun loadDefaultNutrientsAsState(): NutrientGoalState {
        val userInfo = preferences.loadUserInfo()
        return NutrientGoalState(
            carbsRatio = userInfo.carbRatio,
            proteinRatio = userInfo.proteinRatio,
            fatRatio = userInfo.fatRatio
        )
    }
}