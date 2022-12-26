package com.vhontar.core.domain.usecase

class FilterOutDigitsUseCase {
    operator fun invoke(text: String): String = text.filter { it.isDigit() }
}