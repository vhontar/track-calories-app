package com.vhontar.tracker_data.repository

import com.vhontar.core.domain.models.LocalDate
import com.vhontar.tracker_data.local.dao.TrackerDao
import com.vhontar.tracker_data.mapper.toTrackableFood
import com.vhontar.tracker_data.mapper.toTrackedFood
import com.vhontar.tracker_data.mapper.toTrackedFoodEntity
import com.vhontar.tracker_data.remote.OpenFoodApi
import com.vhontar.tracker_domain.model.TrackableFood
import com.vhontar.tracker_domain.model.TrackedFood
import com.vhontar.tracker_domain.repository.TrackerRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class TrackerRepositoryImpl(
    private val dao: TrackerDao,
    private val api: OpenFoodApi
): TrackerRepository {

    override suspend fun searchFood(
        query: String,
        page: Int,
        pageSize: Int
    ): Result<List<TrackableFood>> {
        return try {
            val searchDto = api.searchFood(
                query = query,
                page = page,
                pageSize = pageSize
            )
            Result.success(searchDto.products.mapNotNull { it.toTrackableFood() })
        } catch (e: Exception) {
            e.printStackTrace()
            return Result.failure(e)
        }
    }

    override suspend fun insertTrackedFood(trackedFood: TrackedFood) {
        dao.insertTrackedFood(trackedFood.toTrackedFoodEntity())
    }

    override suspend fun deleteTrackedFood(trackedFood: TrackedFood) {
        dao.deleteTrackedFood(trackedFood.toTrackedFoodEntity())
    }

    override fun getFoodsForDate(date: LocalDate): Flow<List<TrackedFood>> {
        return dao.getFoodsForDate(
            day = date.dayOfMonth,
            month = date.month,
            year = date.year
        ).map { list -> list.map { it.toTrackedFood() } }
    }
}