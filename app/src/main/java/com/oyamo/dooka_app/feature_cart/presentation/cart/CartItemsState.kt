package com.oyamo.dooka_app.feature_cart.presentation.cart

import com.oyamo.dooka_app.feature_cart.domain.model.CartProduct

data class CartItemsState(
    val cartItems: List<CartProduct> = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null
)