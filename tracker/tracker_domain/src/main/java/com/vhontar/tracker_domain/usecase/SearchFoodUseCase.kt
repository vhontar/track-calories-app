package com.vhontar.tracker_domain.usecase

import com.vhontar.tracker_domain.model.TrackableFood
import com.vhontar.tracker_domain.repository.TrackerRepository

class SearchFoodUseCase(
    private val repository: TrackerRepository
) {
    suspend operator fun invoke(
        query: String,
        page: Int = 1,
        pageSize: Int = 40
    ): Result<List<TrackableFood>> {
        if (query.isBlank()) // check for: "", " "
            return Result.success(listOf())

        return repository.searchFood(
            query = query.trim(),
            page = page,
            pageSize = pageSize
        )
    }
}