package com.vhontar.tracker_data.mapper

import com.vhontar.core.domain.models.LocalDate
import com.vhontar.tracker_data.local.entity.TrackedFoodEntity
import com.vhontar.tracker_domain.model.MealType
import com.vhontar.tracker_domain.model.TrackedFood

fun TrackedFoodEntity.toTrackedFood(): TrackedFood {
    return TrackedFood(
        name = name,
        carbs = carbs,
        protein = protein,
        fat = fat,
        imageUrl = imageUrl,
        mealType = MealType.fromString(type),
        amount = amount,
        date = LocalDate(year, month, dayOfMonth),
        calories = calories,
        id = id
    )
}

fun TrackedFood.toTrackedFoodEntity(): TrackedFoodEntity {
    return TrackedFoodEntity(
        name = name,
        carbs = carbs,
        protein = protein,
        fat = fat,
        imageUrl = imageUrl,
        type = mealType.name,
        amount = amount,
        dayOfMonth = date.dayOfMonth,
        month = date.month,
        year = date.year,
        calories = calories,
        id = id
    )
}
