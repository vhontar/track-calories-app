package com.vhontar.tracker_presentation.overview.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.vhontar.core.R
import com.vhontar.core.domain.models.LocalDate
import com.vhontar.core.util.format
import com.vhontar.core.util.minusDays
import com.vhontar.core.util.plusDays

@Composable
fun parseDateText(date: LocalDate): String {
    val today = LocalDate.now()
    return when (date) {
        today -> stringResource(id = R.string.today)
        today.minusDays(1) -> stringResource(id = R.string.yesterday)
        today.plusDays(1) -> stringResource(id = R.string.tomorrow)
        else -> date.format("dd LLLL")
    }
}