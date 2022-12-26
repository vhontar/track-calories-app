package com.vhontar.tracker_domain.usecase

import com.vhontar.core.domain.models.LocalDate
import com.vhontar.tracker_domain.model.TrackedFood
import com.vhontar.tracker_domain.repository.TrackerRepository
import kotlinx.coroutines.flow.Flow

class GetFoodsForDateUseCase(
    private val repository: TrackerRepository
) {
    operator fun invoke(date: LocalDate): Flow<List<TrackedFood>> {
        return repository.getFoodsForDate(date)
    }
}