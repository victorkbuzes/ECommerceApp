package com.example.e_commerceapp.presentation.products.productsList

import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.e_commerceapp.domain.usecases.getProductsList.GetProductsListUseCase
import com.example.e_commerceapp.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class ProductsListViewModel @Inject constructor(
    private  val getProductsListUseCase : GetProductsListUseCase
): ViewModel() {
    private val _state =  mutableStateOf(ProductsListState())
    val state : State<ProductsListState> = _state
    init {
        getProductsList()
    }
    private  fun getProductsList(){
        getProductsListUseCase().onEach { result ->
            when(result){
                is Resource.Success -> {
                    _state.value = ProductsListState(products = result.data ?: emptyList())

                }
                is Resource.Error -> {
                    _state.value = ProductsListState(error = result.message ?:
                    "Unexpected error occurred")

                }
                is Resource.Loading -> {
                    _state.value = ProductsListState(isLoading = true)

                }
            }

        }.launchIn(viewModelScope)

    }



}