package com.oyamo.dooka_app.feature_profile.data

import com.oyamo.dooka_app.feature_auth.data.dto.UserResponseDto
import com.oyamo.dooka_app.feature_profile.domain.model.User

internal fun UserResponseDto.toDomain(): User {
    return User(
        address = address,
        email = email,
        id = id,
        name = name,
        password = password,
        phone = phone,
        username = username
    )
}