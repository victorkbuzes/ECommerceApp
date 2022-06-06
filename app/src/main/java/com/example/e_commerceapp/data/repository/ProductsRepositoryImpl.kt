package com.example.e_commerceapp.data.repository

import com.example.e_commerceapp.data.remote.api.ProductsApi
import com.example.e_commerceapp.data.remote.dto.products.ProductsListDto
import com.example.e_commerceapp.data.remote.dto.products.ProductsInfoDto
import com.example.e_commerceapp.domain.repository.ProductsRepository

import javax.inject.Inject

class ProductsRepositoryImpl  @Inject constructor(
    private  val api: ProductsApi
): ProductsRepository{
    override suspend fun getProductsList(): List<ProductsListDto> {
        return  api.getProductsList()
    }

    override suspend fun getProductsInfo(productsId: Int): ProductsInfoDto {
        return  api.getProductInfo(productsId)
    }

}