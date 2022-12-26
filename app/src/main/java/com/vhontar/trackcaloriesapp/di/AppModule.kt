package com.vhontar.trackcaloriesapp.di

import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import com.vhontar.core.domain.data.preferences.DefaultPreferences
import com.vhontar.core.domain.preferences.Preferences
import com.vhontar.core.domain.usecase.FilterOutDigitsUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun providePreferences(
        sharedPref: SharedPreferences
    ): Preferences = DefaultPreferences(sharedPref)

    @Provides
    @Singleton
    fun provideSharedPreferences(
        @ApplicationContext context: Context
    ): SharedPreferences = context.getSharedPreferences("shared_pref", MODE_PRIVATE)

    @Provides
    @Singleton
    fun provideFilterOutDigitsUseCase(): FilterOutDigitsUseCase = FilterOutDigitsUseCase()
}