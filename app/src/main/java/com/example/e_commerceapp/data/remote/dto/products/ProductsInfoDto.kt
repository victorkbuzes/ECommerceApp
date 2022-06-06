package com.example.e_commerceapp.data.remote.dto.products

import com.example.e_commerceapp.domain.model.ProductsInfo

data class ProductsInfoDto(
    val category: String,
    val description: String,
    var id: Int,
    var image: String,
    var price: Double,
    val rating: RatingDto,
    var title: String

)
fun ProductsInfoDto.toProductsInfo():ProductsInfo{
    return  ProductsInfo(
        category = category,
        description = description,
        id = id,
        image = image,
        price = price,
        rating = rating,
    )

}
