package com.vhontar.tracker_presentation.search

import com.vhontar.core.domain.models.LocalDate
import com.vhontar.tracker_domain.model.MealType
import com.vhontar.tracker_domain.model.TrackableFood

sealed interface SearchEvent {
    data class OnQueryChange(val query: String): SearchEvent
    object OnSearch: SearchEvent
    data class OnToggleTrackableFood(val food: TrackableFood): SearchEvent
    data class OnAmountForFoodChange(
        val food: TrackableFood,
        val amount: String
    ) : SearchEvent
    data class OnTrackFoodClick(
        val food: TrackableFood,
        val mealType: MealType,
        val date: LocalDate
    ): SearchEvent
    data class OnSearchFocusChange(val isFocused: Boolean): SearchEvent
}
