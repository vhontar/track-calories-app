package com.vhontar.tracker_presentation.overview.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.ImageLoader
import coil.compose.rememberAsyncImagePainter
import com.vhontar.core.R
import com.vhontar.core_ui.spacing
import com.vhontar.tracker_domain.model.TrackedFood
import com.vhontar.tracker_presentation.components.NutrientInfo

@Composable
fun TrackedFoodItem(
    trackedFood: TrackedFood,
    onDeleteClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current
    Row(
        modifier = modifier
            .clip(RoundedCornerShape(5.dp))
            .padding(MaterialTheme.spacing.spaceExtraSmall)
            .shadow(
                elevation = 1.dp,
                shape = RoundedCornerShape(5.dp)
            )
            .background(MaterialTheme.colors.surface)
            .padding(end = MaterialTheme.spacing.spaceMedium)
            .height(100.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = rememberAsyncImagePainter(
                model = trackedFood.imageUrl,
                imageLoader = ImageLoader.Builder(context)
                    .crossfade(true)
                    .error(R.drawable.ic_burger)
                    .fallback(R.drawable.ic_burger)
                    .build()
            ),
            contentDescription = trackedFood.name,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxHeight()
                .aspectRatio(1f)
                .clip(RoundedCornerShape(topStart = 5.dp, bottomStart = 5.dp))
        )
        Spacer(modifier = Modifier.width(MaterialTheme.spacing.spaceMedium))
        Column(modifier = Modifier.weight(1f)) {
            Text(
                text = trackedFood.name,
                style = MaterialTheme.typography.body1,
                overflow = TextOverflow.Ellipsis,
                maxLines = 2
            )
            Spacer(modifier = Modifier.height(MaterialTheme.spacing.spaceExtraSmall))
            Text(
                text = stringResource(
                    id = R.string.nutrient_info,
                    trackedFood.amount,
                    trackedFood.calories
                ),
                style = MaterialTheme.typography.body2
            )
        }
        Spacer(modifier = Modifier.width(MaterialTheme.spacing.spaceMedium))
        Column(modifier = Modifier.fillMaxHeight(), verticalArrangement = Arrangement.Center) {
            Icon(
                imageVector = Icons.Default.Close,
                contentDescription = stringResource(id = R.string.delete),
                modifier = Modifier
                    .align(Alignment.End)
                    .clickable { onDeleteClick() }
            )
            Spacer(modifier = Modifier.height(MaterialTheme.spacing.spaceExtraSmall))
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                NutrientInfo(
                    name = stringResource(id = R.string.carbs),
                    amount = trackedFood.carbs,
                    unit = stringResource(id = R.string.grams),
                    amountTextSize = 16.sp,
                    unitTextSize = 12.sp,
                    nameTextStyle = MaterialTheme.typography.body2
                )
                Spacer(modifier = Modifier.width(MaterialTheme.spacing.spaceSmall))
                NutrientInfo(
                    name = stringResource(id = R.string.protein),
                    amount = trackedFood.protein,
                    unit = stringResource(id = R.string.grams),
                    amountTextSize = 16.sp,
                    unitTextSize = 12.sp,
                    nameTextStyle = MaterialTheme.typography.body2
                )
                Spacer(modifier = Modifier.width(MaterialTheme.spacing.spaceSmall))
                NutrientInfo(
                    name = stringResource(id = R.string.fat),
                    amount = trackedFood.fat,
                    unit = stringResource(id = R.string.grams),
                    amountTextSize = 16.sp,
                    unitTextSize = 12.sp,
                    nameTextStyle = MaterialTheme.typography.body2
                )
            }
        }
    }
}