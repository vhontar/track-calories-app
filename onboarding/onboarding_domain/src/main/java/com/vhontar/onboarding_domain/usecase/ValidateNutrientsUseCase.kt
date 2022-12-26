package com.vhontar.onboarding_domain.usecase

import com.vhontar.core.util.UiText
import com.vhontar.core.R

class ValidateNutrientsUseCase {
    operator fun invoke(
        carbsRatioText: String,
        proteinRatioText: String,
        fatRatioText: String
    ): Result {
        val carbsRatio = carbsRatioText.toIntOrNull()
        val proteinRatio = proteinRatioText.toIntOrNull()
        val fatRatio = fatRatioText.toIntOrNull()

        if (carbsRatio == null || proteinRatio == null || fatRatio == null)
            return Result.Error(
                message = UiText.StringResource(R.string.error_invalid_values)
            )

        if (carbsRatio + proteinRatio + fatRatio != 100)
            return Result.Error(
                message = UiText.StringResource(R.string.error_not_100_percent)
            )

        return Result.Success(
            carbsRatio = carbsRatio / 100f,
            proteinRatio = proteinRatio / 100f,
            fatRatio = fatRatio / 100f
        )
    }

    sealed interface Result {
        data class Success(
            val carbsRatio: Float,
            val proteinRatio: Float,
            val fatRatio: Float
        ) : Result
        data class Error(val message: UiText): Result
    }
}