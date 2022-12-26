package com.vhontar.onboarding_presentation.nutrientgoal

sealed interface NutrientGoalEvent {
    data class OnCarbRatioEnter(val ratio: String): NutrientGoalEvent
    data class OnProteinRatioEnter(val ratio: String): NutrientGoalEvent
    data class OnFatRatioEnter(val ratio: String): NutrientGoalEvent
    object OnNextClick: NutrientGoalEvent
    object OnBackClick: NutrientGoalEvent
}