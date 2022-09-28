package com.oyamo.dooka_app.feature_products.domain.use_case

import com.oyamo.dooka_app.core.util.Resource
import com.oyamo.dooka_app.feature_products.domain.model.Product
import com.oyamo.dooka_app.feature_products.domain.repository.ProductsRepository
import kotlinx.coroutines.flow.Flow

class GetProductsUseCase(
    private val productsRepository: ProductsRepository
) {
    suspend operator fun invoke(): Flow<Resource<List<Product>>> {
        return productsRepository.getProducts()
    }
}