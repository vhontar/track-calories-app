package com.vhontar.onboarding_presentation.goaltype

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.hilt.navigation.compose.hiltViewModel
import com.vhontar.core.R
import com.vhontar.core.domain.models.GoalType
import com.vhontar.core.util.UiEvent
import com.vhontar.core_ui.spacing
import com.vhontar.onboarding_presentation.components.ActionButton
import com.vhontar.onboarding_presentation.components.SelectableButton
import kotlinx.coroutines.flow.collectLatest

@Composable
fun GoalTypeScreen(
    onNextClick: () -> Unit,
    onBackClick: () -> Unit,
    viewModel: GoalTypeViewModel = hiltViewModel()
) {
    LaunchedEffect(key1 = Unit) {
        viewModel.uiEvent.collectLatest { event ->
            when (event) {
                is UiEvent.Next -> onNextClick()
                is UiEvent.Back -> onBackClick()
                else -> Unit
            }
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(MaterialTheme.spacing.spaceLarge)
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = stringResource(id = R.string.lose_keep_or_gain_weight),
                style = MaterialTheme.typography.h3
            )
            Spacer(modifier = Modifier.height(MaterialTheme.spacing.spaceMedium))
            Row {
                SelectableButton(
                    text = stringResource(id = R.string.lose),
                    isSelected = viewModel.selectedGoalType is GoalType.LoseWeight,
                    color = MaterialTheme.colors.primaryVariant,
                    selectedTextColor = Color.White,
                    onClick = { viewModel.onGoalTypeClick(GoalType.LoseWeight) },
                    textStyle = MaterialTheme.typography.button.copy(
                        fontWeight = FontWeight.Normal
                    )
                )
                Spacer(modifier = Modifier.width(MaterialTheme.spacing.spaceMedium))
                SelectableButton(
                    text = stringResource(id = R.string.keep),
                    isSelected = viewModel.selectedGoalType is GoalType.KeepWeight,
                    color = MaterialTheme.colors.primaryVariant,
                    selectedTextColor = Color.White,
                    onClick = { viewModel.onGoalTypeClick(GoalType.KeepWeight) },
                    textStyle = MaterialTheme.typography.button.copy(
                        fontWeight = FontWeight.Normal
                    )
                )
                Spacer(modifier = Modifier.width(MaterialTheme.spacing.spaceMedium))
                SelectableButton(
                    text = stringResource(id = R.string.gain),
                    isSelected = viewModel.selectedGoalType is GoalType.GainWeight,
                    color = MaterialTheme.colors.primaryVariant,
                    selectedTextColor = Color.White,
                    onClick = { viewModel.onGoalTypeClick(GoalType.GainWeight) },
                    textStyle = MaterialTheme.typography.button.copy(
                        fontWeight = FontWeight.Normal
                    )
                )
            }
        }
        ActionButton(
            text = stringResource(id = R.string.back),
            onClick = viewModel::onBackClick,
            modifier = Modifier.align(Alignment.BottomStart)
        )
        ActionButton(
            text = stringResource(id = R.string.next),
            onClick = viewModel::onNextClick,
            modifier = Modifier.align(Alignment.BottomEnd)
        )
    }
}