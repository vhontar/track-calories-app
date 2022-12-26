package com.vhontar.onboarding_presentation.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.sp
import com.vhontar.core_ui.spacing

@Composable
fun UnitTextField(
    value: Int,
    range: IntRange,
    onValueChanged: (Int) -> Unit,
    unit: String,
    modifier: Modifier = Modifier,
    textStyle: TextStyle = TextStyle(
        color = MaterialTheme.colors.primaryVariant,
        fontSize = 24.sp
    )
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.Center
    ) {
        NumberPicker(
            value = value,
            range = range,
            onValueChange = onValueChanged,
            textStyle = textStyle,
            modifier = Modifier
                .width(IntrinsicSize.Min)
        )
        Spacer(modifier = Modifier.width(MaterialTheme.spacing.spaceSmall))
        Text(
            text = unit,
            modifier = Modifier.align(Alignment.CenterVertically)
        )
    }
}