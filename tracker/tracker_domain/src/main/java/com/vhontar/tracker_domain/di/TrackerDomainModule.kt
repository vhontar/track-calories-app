package com.vhontar.tracker_domain.di

import com.vhontar.core.domain.preferences.Preferences
import com.vhontar.tracker_domain.repository.TrackerRepository
import com.vhontar.tracker_domain.usecase.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object TrackerDomainModule {

    @Provides
    @Singleton
    fun provideTrackerUseCases(
        repository: TrackerRepository,
        preferences: Preferences
    ): TrackerUseCases = TrackerUseCases(
        trackFood = TrackFoodUseCase(repository),
        searchFood = SearchFoodUseCase(repository),
        getFoodsForDate = GetFoodsForDateUseCase(repository),
        deleteTrackedFood = DeleteTrackedFoodUseCase(repository),
        calculateMealNutrients = CalculateMealNutrientsUseCase(preferences)
    )
}