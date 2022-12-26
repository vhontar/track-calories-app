package com.vhontar.core.domain.models

import com.vhontar.core.util.toLocalDate
import java.util.*

data class LocalDate(
    val year: Int,
    val month: Int,
    val dayOfMonth: Int
) {
    companion object {
        fun now(): LocalDate = Calendar.getInstance().time.toLocalDate()
    }
}
