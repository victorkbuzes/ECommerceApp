package com.example.e_commerceapp.presentation.products.productsList.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.request.ImageRequest
import com.example.e_commerceapp.domain.model.ProductsList
import com.google.accompanist.coil.CoilImage

@Composable
fun ProductsListItem(
    productsList: ProductsList,
    modifier: Modifier = Modifier,
    navController: NavController
){
    Box(
        modifier = Modifier
            .fillMaxWidth()
//            .clickable { onItemClick(productsList) }
            .padding(20.dp)

    ) {
        Column {
            CoilImage(request = ImageRequest.Builder(LocalContext.current)
                .data(productsList)
                .build(),
            contentDescription = productsList.title,
            fadeIn = true,
            modifier = Modifier
                .size(120.dp)
                .align(CenterHorizontally)) {
                CircularProgressIndicator(
                    color = MaterialTheme.colors.primary,
                    modifier = Modifier.scale(0.5f)
                )
            }
            Text(text = productsList.title, fontSize = 20.sp, textAlign = TextAlign.Center)
            Spacer(modifier = Modifier.height(10.dp))
            Text(text = productsList.price.toString(), fontSize = 10.sp, textAlign = TextAlign.Center, modifier = Modifier.fillMaxWidth())
        }
    }
}

@Composable
fun ProductsListRow(
    rowIndex: Int,
    productsLists: List<ProductsList>,
    navController: NavController
){
    Column {
        Row() {
            ProductsListItem(
                productsList = productsLists[rowIndex *2],
                navController = navController,
                modifier = Modifier.weight(1f)
            )
            Spacer(modifier = Modifier.width(16.dp))
            if (productsLists.size >= rowIndex * 2 + 2){
                ProductsListItem(
                    productsList = productsLists[rowIndex *2 + 1 ] ,
                    navController = navController,
                    modifier = Modifier.weight(1f)
                )

            } else {
                Spacer(modifier = Modifier.weight(1f))
            }

        }
        Spacer(modifier = Modifier.height(16.dp)) 

    }

}








