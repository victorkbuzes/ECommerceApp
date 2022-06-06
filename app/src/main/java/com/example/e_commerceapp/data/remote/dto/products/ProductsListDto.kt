package com.example.e_commerceapp.data.remote.dto.products

import com.example.e_commerceapp.domain.model.ProductsList

data class ProductsListDto(
    val category: String,
    val description: String,
    var id: Int,
    var image: String,
    var price: Double,
    val rating: RatingDto,
    var title: String
)
fun ProductsListDto.toProductsList():ProductsList{
    return  ProductsList(
        id = id,
        image = image,
        price = price,
        title = title,

    )

}


