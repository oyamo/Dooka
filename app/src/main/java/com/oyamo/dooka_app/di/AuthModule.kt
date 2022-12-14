package com.oyamo.dooka_app.di

import com.oyamo.dooka_app.core.util.Constants.BASE_URL
import com.oyamo.dooka_app.feature_auth.data.local.AuthPreferences
import com.oyamo.dooka_app.feature_auth.data.remote.AuthApiService
import com.oyamo.dooka_app.feature_auth.data.repository.LoginRepositoryImpl
import com.oyamo.dooka_app.feature_auth.domain.repository.LoginRepository
import com.oyamo.dooka_app.feature_auth.domain.use_case.AutoLoginUseCase
import com.oyamo.dooka_app.feature_auth.domain.use_case.LoginUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AuthModule {

    @Provides
    @Singleton
    fun provideAuthApiService(): AuthApiService {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(AuthApiService::class.java)
    }

    @Provides
    @Singleton
    fun provideLoginRepository(
        authApiService: AuthApiService,
        authPreferences: AuthPreferences
    ): LoginRepository {
        return LoginRepositoryImpl(
            authApiService = authApiService,
            authPreferences = authPreferences
        )
    }

    @Provides
    @Singleton
    fun provideLoginUseCase(loginRepository: LoginRepository): LoginUseCase {
        return LoginUseCase(loginRepository)
    }

    @Provides
    @Singleton
    fun provideAutoLoginUseCase(loginRepository: LoginRepository): AutoLoginUseCase {
        return AutoLoginUseCase(loginRepository)
    }
}