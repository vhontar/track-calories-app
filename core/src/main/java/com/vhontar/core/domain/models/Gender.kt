package com.vhontar.core.domain.models

sealed class Gender(val name: String) {
    object Male : Gender("male")
    object Female : Gender("female")

    companion object {
        fun fromString(name: String?): Gender = when (name) {
            null -> Male
            "male" -> Male
            "female" -> Female
            else -> throw IllegalArgumentException("Gender is not specified correctly")
        }
    }
}
