package com.example.e_commerceapp.domain.repository

import com.example.e_commerceapp.data.remote.dto.products.ProductsListDto
import com.example.e_commerceapp.data.remote.dto.products.ProductsInfoDto


interface ProductsRepository {

    suspend fun getProductsList(): List<ProductsListDto>
    suspend fun getProductsInfo(productsId: Int): ProductsInfoDto
}
