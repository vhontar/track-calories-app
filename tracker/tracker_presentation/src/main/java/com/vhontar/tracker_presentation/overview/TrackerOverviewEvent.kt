package com.vhontar.tracker_presentation.overview

import com.vhontar.tracker_domain.model.TrackedFood

sealed interface TrackerOverviewEvent {
    object OnNextDayClick: TrackerOverviewEvent
    object OnPreviousDayClick: TrackerOverviewEvent
    data class OnToggleMealClick(val meal: Meal): TrackerOverviewEvent
    data class OnDeleteTrackedFoodClick(val trackedFood: TrackedFood): TrackerOverviewEvent
}