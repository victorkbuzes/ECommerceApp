package com.example.e_commerceapp.domain.usecases.getProductInfo

import com.example.e_commerceapp.data.remote.dto.products.toProductsInfo
import com.example.e_commerceapp.domain.model.ProductsInfo
import com.example.e_commerceapp.domain.repository.ProductsRepository
import com.example.e_commerceapp.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetProductInfoUseCase @Inject constructor(
    private  val repository: ProductsRepository
) {
    operator fun invoke(productId:Int): Flow<Resource<ProductsInfo>> = flow {
        try {
            emit(Resource.Loading())
            val product = repository.getProductsInfo(productId).toProductsInfo()
            emit(Resource.Success(product))
        } catch (e:HttpException){
            e.printStackTrace()
            emit(Resource.Error(e.localizedMessage?:"Could not load data"))
        }catch (e:IOException){
            e.printStackTrace()
            emit(Resource.Error("Could not reach server.Check internet connection"))
        }
    }

}