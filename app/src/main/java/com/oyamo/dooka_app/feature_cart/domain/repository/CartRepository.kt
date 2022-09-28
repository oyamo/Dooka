package com.oyamo.dooka_app.feature_cart.domain.repository

import com.oyamo.dooka_app.core.util.Resource
import com.oyamo.dooka_app.feature_cart.domain.model.CartProduct
import kotlinx.coroutines.flow.Flow

interface CartRepository {
    suspend fun getAllCartItems(id: Int): Flow<Resource<List<CartProduct>>>
}