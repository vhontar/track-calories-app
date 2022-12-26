package com.vhontar.onboarding_presentation.nutrientgoal

data class NutrientGoalState(
    val carbsRatioAsText: String = "40",
    val proteinRatioAsText: String = "30",
    val fatRatioAsText: String = "30"
) {
    constructor(carbsRatio: Float, proteinRatio: Float, fatRatio: Float): this(
        carbsRatioAsText = if (carbsRatio == -1f) "40" else (carbsRatio * 100).toString(),
        proteinRatioAsText = if (proteinRatio == -1f) "30" else (proteinRatio * 100).toString(),
        fatRatioAsText = if (fatRatio == -1f) "30" else (fatRatio * 100).toString()
    )
}
