package com.vhontar.core.util

import com.vhontar.core.domain.models.LocalDate
import java.util.*

fun Date.toLocalDate(): LocalDate {
    val calendar = Calendar.getInstance().apply {
        time = this@toLocalDate
    }

    return LocalDate(
        year = calendar.get(Calendar.YEAR),
        month = calendar.get(Calendar.MONTH),
        dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH)
    )
}

fun LocalDate.toDate(): Date {
    val calendar = Calendar.getInstance().apply {
        set(year, month, dayOfMonth)
    }

    return calendar.time
}

fun LocalDate.plusDays(days: Int): LocalDate {
    val calendar = Calendar.getInstance().apply {
        time = toDate()
    }
    calendar.add(Calendar.DAY_OF_MONTH, days)
    return calendar.time.toLocalDate()
}

fun LocalDate.minusDays(days: Int): LocalDate {
    val calendar = Calendar.getInstance().apply {
        time = toDate()
    }
    calendar.add(Calendar.DAY_OF_MONTH, -days)
    return calendar.time.toLocalDate()
}