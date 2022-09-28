package com.oyamo.dooka_app.feature_auth.domain.model

import com.oyamo.dooka_app.core.util.Resource

data class LoginResult(
    val passwordError: String? = null,
    val usernameError: String? = null,
    val result: Resource<Unit>? = null
)
