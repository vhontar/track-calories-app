package com.vhontar.onboarding_presentation.nutrientgoal

import kotlin.math.roundToInt

data class NutrientGoalState(
    val carbsRatioAsText: String = "40",
    val proteinRatioAsText: String = "30",
    val fatRatioAsText: String = "30"
) {
    constructor(carbsRatio: Float, proteinRatio: Float, fatRatio: Float): this(
        carbsRatioAsText = if (carbsRatio != -1f) {
            (carbsRatio * 100).roundToInt().toString()
        } else "40",
        proteinRatioAsText = if (proteinRatio != -1f) {
            (proteinRatio * 100).roundToInt().toString()
        } else "30",
        fatRatioAsText = if (fatRatio != -1f) {
            (fatRatio * 100).roundToInt().toString()
        } else "30"
    )
}
