package com.vhontar.tracker_domain.usecase

import com.google.common.truth.Truth.assertThat
import com.vhontar.core.domain.models.*
import com.vhontar.core.domain.preferences.Preferences
import com.vhontar.tracker_domain.model.MealType
import com.vhontar.tracker_domain.model.TrackedFood
import io.mockk.every
import io.mockk.mockk
import org.junit.Before
import org.junit.Test
import kotlin.random.Random

class CalculateMealNutrientsTest {

    private lateinit var calculateMealNutrients: CalculateMealNutrientsUseCase

    @Before
    fun setUp() {
        val preferences = mockk<Preferences>(relaxed = true)
        every { preferences.loadUserInfo() } returns UserInfo(
            gender = Gender.Male,
            age = 20,
            weight = 80,
            height = 180,
            activityLevel = ActivityLevel.Medium,
            goalType = GoalType.KeepWeight,
            carbsRatio = 0.4f,
            proteinRatio = 0.3f,
            fatRatio = 0.3f
        )
        calculateMealNutrients = CalculateMealNutrientsUseCase(preferences)
    }

    @Test
    fun `Calories for breakfast properly calculated`() {
        val trackedFoods = (1..30).map {
            TrackedFood(
                name = "name",
                carbs = Random.nextInt(100),
                protein = Random.nextInt(100),
                fat = Random.nextInt(100),
                mealType = MealType.fromString(
                    listOf("breakfast", "lunch", "dinner", "snack").random()
                ),
                imageUrl = null,
                amount = 100,
                date = LocalDate.now(),
                calories = Random.nextInt(2000)
            )
        }

        val result = calculateMealNutrients(trackedFoods)

        val breakfastCalories = result.mealNutrients.values
            .filter { it.mealType is MealType.Breakfast }
            .sumOf { it.calories }
        val expectedCalories = trackedFoods
            .filter { it.mealType is MealType.Breakfast }
            .sumOf { it.calories }

        assertThat(breakfastCalories).isEqualTo(expectedCalories)
    }

    @Test
    fun `Carbs for dinner properly calculated`() {
        val trackedFoods = (1..30).map {
            TrackedFood(
                name = "name",
                carbs = Random.nextInt(100),
                protein = Random.nextInt(100),
                fat = Random.nextInt(100),
                mealType = MealType.fromString(
                    listOf("breakfast", "lunch", "dinner", "snack").random()
                ),
                imageUrl = null,
                amount = 100,
                date = LocalDate.now(),
                calories = Random.nextInt(2000)
            )
        }

        val result = calculateMealNutrients(trackedFoods)

        val dinnerCarbs = result.mealNutrients.values
            .filter { it.mealType is MealType.Dinner }
            .sumOf { it.carbs }
        val expectedCarbs = trackedFoods
            .filter { it.mealType is MealType.Dinner }
            .sumOf { it.carbs }

        assertThat(dinnerCarbs).isEqualTo(expectedCarbs)
    }
}