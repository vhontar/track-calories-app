package com.vhontar.core.domain.models

sealed class GoalType(val name: String) {
    object LoseWeight : GoalType("lose_weight")
    object KeepWeight : GoalType("keep_weight")
    object GainWeight : GoalType("gain_weight")

    companion object {
        fun fromString(name: String?): GoalType = when (name) {
            null -> KeepWeight
            "lose_weight" -> LoseWeight
            "keep_weight" -> KeepWeight
            "gain_weight" -> GainWeight
            else -> throw IllegalArgumentException("GoalType is not specified correctly")
        }
    }
}