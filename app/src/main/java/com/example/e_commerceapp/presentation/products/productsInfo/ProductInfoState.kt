package com.example.e_commerceapp.presentation.products.productsInfo

import com.example.e_commerceapp.domain.model.ProductsInfo


data class ProductInfoState(
    val product: ProductsInfo? = null,
    val isLoading: Boolean = false,
    val error: String = "",
    val isRefreshing: Boolean = false,
    val searchQuery: String = ""
)
