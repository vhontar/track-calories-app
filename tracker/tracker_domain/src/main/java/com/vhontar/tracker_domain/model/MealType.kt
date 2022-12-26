package com.vhontar.tracker_domain.model

sealed class MealType(val name: String) {
    object Breakfast : MealType("breakfast")
    object Lunch : MealType("lunch")
    object Dinner : MealType("dinner")
    object Snack : MealType("snack")

    companion object {
        fun fromString(name: String): MealType = when (name) {
            "breakfast" -> Breakfast
            "lunch" -> Lunch
            "dinner" -> Dinner
            "snack" -> Snack
            else -> throw IllegalArgumentException("Not supported meal type.")
        }
    }
}