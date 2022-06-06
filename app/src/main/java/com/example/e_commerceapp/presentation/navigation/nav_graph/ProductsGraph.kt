package com.example.e_commerceapp.presentation.navigation.nav_graph

import androidx.compose.runtime.remember
import androidx.navigation.*
import androidx.navigation.compose.composable

import com.example.e_commerceapp.presentation.navigation.Screen
import com.example.e_commerceapp.presentation.products.productsInfo.ProductInfoScreen
import com.example.e_commerceapp.presentation.products.productsList.components.ProductsListScreen


fun NavGraphBuilder.productsNavGraph(
    navController: NavController
){
    navigation(startDestination = Screen.ProductList.route, route = Screen.ProductList.route){
        composable(route = Screen.ProductList.route){
            ProductsListScreen(navController = navController)
        }
        composable(route = Screen.ProductInfo.route+ "/productId"){
            ProductInfoScreen()
        }
    }

}