package com.example.e_commerceapp.presentation.products.productsInfo

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.e_commerceapp.constants.Constants
import com.example.e_commerceapp.domain.usecases.getProductInfo.GetProductInfoUseCase
import com.example.e_commerceapp.presentation.products.productsList.ProductsListState
import com.example.e_commerceapp.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class ProductsInfoViewModel @Inject constructor(
    private  val getProductsInfoUseCase : GetProductInfoUseCase,
    savedStateHandle: SavedStateHandle
): ViewModel() {
    private val _state =  mutableStateOf(ProductInfoState())
    val state : State<ProductInfoState> = _state
    init {
        savedStateHandle.get<Int>(Constants.PARAM_PRODUCT_ID)?.let { productId ->
            getProductInfo(productId)
        }

    }
    private  fun getProductInfo(productId : Int){
        getProductsInfoUseCase(productId).onEach { result ->
            when(result){
                is Resource.Success -> {
                    _state.value = ProductInfoState(product = result.data)

                }
                is Resource.Error -> {
                    _state.value = ProductInfoState(error = result.message ?:
                    "Unexpected error occurred")

                }
                is Resource.Loading -> {
                    _state.value = ProductInfoState(isLoading = true)

                }
            }

        }.launchIn(viewModelScope)

    }



}