package com.vhontar.tracker_domain.usecase

import com.vhontar.tracker_domain.model.TrackedFood
import com.vhontar.tracker_domain.repository.TrackerRepository

class DeleteTrackedFoodUseCase (
    private val repository: TrackerRepository
) {
    suspend operator fun invoke(trackedFood: TrackedFood){
        repository.deleteTrackedFood(trackedFood)
    }
}