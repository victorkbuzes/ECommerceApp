package com.example.e_commerceapp.presentation.products.productsList


import com.example.e_commerceapp.domain.model.ProductsList


data class ProductsListState(
    val products: List<ProductsList> = emptyList(),
    val isLoading: Boolean = false,
    val error: String = "",
    val endReached: Boolean = false,
    val isRefreshing: Boolean = false,
    val searchQuery: String = ""
)
