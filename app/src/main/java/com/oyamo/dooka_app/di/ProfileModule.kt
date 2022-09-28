package com.oyamo.dooka_app.di

import com.google.gson.Gson
import com.oyamo.dooka_app.feature_auth.data.local.AuthPreferences
import com.oyamo.dooka_app.feature_profile.data.repository.ProfileRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ProfileModule {
    @Provides
    @Singleton
    fun provideProfileRepository(authPreferences: AuthPreferences, gson: Gson): ProfileRepository {
        return ProfileRepository(authPreferences, gson)
    }
}