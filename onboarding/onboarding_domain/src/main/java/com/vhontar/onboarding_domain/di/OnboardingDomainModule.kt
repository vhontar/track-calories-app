package com.vhontar.onboarding_domain.di

import com.vhontar.onboarding_domain.usecase.ValidateNutrientsUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object OnboardingDomainModule {

    @Provides
    @Singleton
    fun provideValidateNutientsUseCase(): ValidateNutrientsUseCase = ValidateNutrientsUseCase()
}