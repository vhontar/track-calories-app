package com.vhontar.tracker_data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.vhontar.tracker_data.local.dao.TrackerDao
import com.vhontar.tracker_data.local.entity.TrackedFoodEntity

@Database(
    entities = [TrackedFoodEntity::class],
    version = 1
)
abstract class TrackerDatabase: RoomDatabase() {
    abstract val trackerDao: TrackerDao
}