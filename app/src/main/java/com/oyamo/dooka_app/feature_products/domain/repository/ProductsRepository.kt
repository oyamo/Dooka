package com.oyamo.dooka_app.feature_products.domain.repository

import com.oyamo.dooka_app.core.util.Resource
import com.oyamo.dooka_app.feature_products.domain.model.Product
import kotlinx.coroutines.flow.Flow

interface ProductsRepository {
    suspend fun getProducts(): Flow<Resource<List<Product>>>
    suspend fun getProductCategories(): List<String>
}