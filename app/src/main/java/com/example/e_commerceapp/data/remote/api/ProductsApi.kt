package com.example.e_commerceapp.data.remote.api

import com.example.e_commerceapp.constants.Constants
import com.example.e_commerceapp.data.remote.dto.products.ProductsListDto
import com.example.e_commerceapp.data.remote.dto.products.ProductsInfoDto
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import javax.inject.Singleton



@Singleton
interface ProductsApi {
    @GET("/products")

    suspend fun  getProductsList(): List<ProductsListDto>

    @GET("/products/{${Constants.PARAM_PRODUCT_ID}}")
    suspend fun  getProductInfo(
        @Path(Constants.PARAM_PRODUCT_ID) productId: Int): ProductsInfoDto
}


