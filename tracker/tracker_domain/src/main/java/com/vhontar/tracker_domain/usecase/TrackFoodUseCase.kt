package com.vhontar.tracker_domain.usecase

import com.vhontar.core.domain.models.LocalDate
import com.vhontar.tracker_domain.model.MealType
import com.vhontar.tracker_domain.model.TrackableFood
import com.vhontar.tracker_domain.model.TrackedFood
import com.vhontar.tracker_domain.repository.TrackerRepository
import kotlin.math.roundToInt

class TrackFoodUseCase(
    private val repository: TrackerRepository
) {
    suspend operator fun invoke(
        food: TrackableFood,
        amount: Int,
        mealType: MealType,
        date: LocalDate
    ) {
        repository.insertTrackedFood(
            TrackedFood(
                name = food.name,
                carbs = ((food.carbsPer100g / 100f) * amount).roundToInt(),
                protein = ((food.proteinPer100g / 100f) * amount).roundToInt(),
                fat = ((food.fatPer100g / 100f) * amount).roundToInt(),
                calories = ((food.caloriesPer100g / 100f) * amount).roundToInt(),
                imageUrl = food.imageUrl,
                mealType = mealType,
                amount = amount,
                date = date
            )
        )
    }
}