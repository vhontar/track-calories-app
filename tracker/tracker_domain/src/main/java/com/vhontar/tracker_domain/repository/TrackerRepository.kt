package com.vhontar.tracker_domain.repository

import com.vhontar.core.domain.models.LocalDate
import com.vhontar.tracker_domain.model.TrackableFood
import com.vhontar.tracker_domain.model.TrackedFood
import kotlinx.coroutines.flow.Flow
import java.util.Date

interface TrackerRepository {
    suspend fun searchFood(
        query: String,
        page: Int,
        pageSize: Int
    ): Result<List<TrackableFood>>

    suspend fun insertTrackedFood(trackedFood: TrackedFood)

    suspend fun deleteTrackedFood(trackedFood: TrackedFood)

    fun getFoodsForDate(date: LocalDate): Flow<List<TrackedFood>>
}