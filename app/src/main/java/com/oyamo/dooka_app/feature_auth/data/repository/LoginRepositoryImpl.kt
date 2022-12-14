package com.oyamo.dooka_app.feature_auth.data.repository

import com.oyamo.dooka_app.core.util.Resource
import com.oyamo.dooka_app.feature_auth.data.dto.UserResponseDto
import com.oyamo.dooka_app.feature_auth.data.local.AuthPreferences
import com.oyamo.dooka_app.feature_auth.data.remote.AuthApiService
import com.oyamo.dooka_app.feature_auth.data.remote.request.LoginRequest
import com.oyamo.dooka_app.feature_auth.domain.repository.LoginRepository
import kotlinx.coroutines.flow.first
import retrofit2.HttpException
import timber.log.Timber
import java.io.IOException

class LoginRepositoryImpl(
    private val authApiService: AuthApiService,
    private val authPreferences: AuthPreferences
) : LoginRepository {
    override suspend fun login(loginRequest: LoginRequest, rememberMe: Boolean): Resource<Unit> {
        Timber.d("Login called")
        return try {
            val response = authApiService.loginUser(loginRequest)
            Timber.d(response.token)
            authPreferences.saveAccessToken(response.token)
            getAllUsers(loginRequest.username)?.let { authPreferences.saveUserdata(it) }
            Resource.Success(Unit)
        } catch (e: IOException) {
            Resource.Error(message = "Could not reach the server, please check your internet connection!")
        } catch (e: HttpException) {
            Resource.Error(message = "An Unknown error occurred, please try again!")
        }
    }

    override suspend fun autoLogin(): Resource<Unit> {
        val accessToken = authPreferences.getAccessToken.first()
        Timber.d("Auto login access token: $accessToken")
        return if (accessToken != "") {
            Resource.Success(Unit)
        } else {
            Resource.Error("")
        }
    }

    private suspend fun getAllUsers(name: String): UserResponseDto? {
        val response = authApiService.getAllUsers()
        return response.find { it.username == name }
    }
}