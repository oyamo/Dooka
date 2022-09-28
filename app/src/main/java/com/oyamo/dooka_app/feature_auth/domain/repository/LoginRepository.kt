package com.oyamo.dooka_app.feature_auth.domain.repository

import com.oyamo.dooka_app.core.util.Resource
import com.oyamo.dooka_app.feature_auth.data.remote.request.LoginRequest

interface LoginRepository {
    suspend fun login(loginRequest: LoginRequest, rememberMe: Boolean): Resource<Unit>
    suspend fun autoLogin(): Resource<Unit>
}