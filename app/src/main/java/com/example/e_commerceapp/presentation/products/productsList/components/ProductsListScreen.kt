package com.example.e_commerceapp.presentation.products.productsList.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.e_commerceapp.presentation.navigation.Screen
import com.example.e_commerceapp.presentation.products.productsList.ProductsListViewModel

@Composable
fun ProductsListScreen(
    navController: NavController,
    viewModel: ProductsListViewModel = hiltViewModel()
) {
    val state = viewModel.state.value
    Surface(
        color = MaterialTheme.colors.background,
        modifier = Modifier.fillMaxSize()
    ) {
        Column() {
            Spacer(modifier = Modifier.height(16.dp))
            SearchBar()
        }
        Box(modifier = Modifier.fillMaxSize()){

//            LazyColumn(modifier = Modifier.fillMaxSize()){
//                items(state.products){ product ->
//                    ProductsListItem(
//                        productsList = product ,
//                        onItemClick = {
//                            navController.navigate(Screen.ProductInfo.route + "/${product.id}")
//                        })
//                }
//            }
//            if (state.error.isNotBlank()){
//                Text(text = state.error,
//                    color = MaterialTheme.colors.error,
//                    textAlign = TextAlign.Center,
//                    modifier = Modifier
//                        .fillMaxWidth()
//                        .padding(horizontal = 20.dp)
//                        .align(Alignment.Center)
//                    )
//            }
//            if (state.isLoading){
//                CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
//
//            }
        }
    }
}
@Composable
fun SearchBar(
    modifier: Modifier = Modifier,
    onSearch: (String) -> Unit = {}
) {
    var text by remember { mutableStateOf("") }
    Column(modifier = modifier) {
        OutlinedTextField(value = text,
            onValueChange = {
                text = it
                onSearch(it)
            },
            placeholder = {
                Text(text = "Search Here..")
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            maxLines = 1,
            singleLine = true
        )
    }

}
