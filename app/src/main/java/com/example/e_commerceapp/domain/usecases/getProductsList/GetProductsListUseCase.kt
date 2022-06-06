package com.example.e_commerceapp.domain.usecases.getProductsList

import com.example.e_commerceapp.data.remote.dto.products.toProductsList
import com.example.e_commerceapp.domain.model.ProductsList
import com.example.e_commerceapp.domain.repository.ProductsRepository
import com.example.e_commerceapp.utils.Resource
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetProductsListUseCase @Inject constructor(
    private  val repository: ProductsRepository
) {
    operator fun invoke(): Flow<Resource<List<ProductsList>>> = flow {
        try {
            emit(Resource.Loading())
            val products = repository.getProductsList().map { it.toProductsList() }
            emit(Resource.Success(products))
        } catch (e: HttpException){
            e.printStackTrace()
            emit(Resource.Error(e.localizedMessage?:"Could not load data"))
        }catch (e: IOException){
            e.printStackTrace()
            emit(Resource.Error("Could not reach server.Check internet connection"))
        }
    }

}