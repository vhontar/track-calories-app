package com.vhontar.core.domain.models

data class UserInfo(
    val gender: Gender,
    val age: Int,
    val weight: Int,
    val height: Int,
    val activityLevel: ActivityLevel,
    val goalType: GoalType,
    val carbsRatio: Float,
    val proteinRatio: Float,
    val fatRatio: Float
)
