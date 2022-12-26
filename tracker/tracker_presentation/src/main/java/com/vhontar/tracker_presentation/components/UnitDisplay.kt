package com.vhontar.tracker_presentation.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.LastBaseline
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import com.vhontar.core_ui.spacing

@Composable
fun UnitDisplay(
    amount: Int,
    unit: String,
    modifier: Modifier = Modifier,
    amountTextSize: TextUnit = 20.sp,
    amountColor: Color = MaterialTheme.colors.onBackground,
    unitTextSize: TextUnit = 14.sp,
    unitColor: Color = MaterialTheme.colors.onBackground
) {
    Row(modifier = modifier) {
        Text(
            text = amount.toString(),
            fontSize = amountTextSize,
            color = amountColor,
            style = MaterialTheme.typography.h1,
            modifier = Modifier.alignBy(LastBaseline)
        )
        Spacer(modifier = Modifier.width(MaterialTheme.spacing.spaceExtraSmall))
        Text(
            text = unit,
            fontSize = unitTextSize,
            color = unitColor,
            style = MaterialTheme.typography.body1,
            modifier = Modifier.alignBy(LastBaseline)
        )
    }
}