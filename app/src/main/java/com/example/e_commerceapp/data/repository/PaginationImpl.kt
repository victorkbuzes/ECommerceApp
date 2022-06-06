package com.example.e_commerceapp.data.repository

import com.example.e_commerceapp.utils.Resource

class PaginationImpl<Key, Item> (
    private  val initialKey:Key,
    private  inline val onLoadUpdated : (Boolean) -> Unit,
    private  inline val onRequest: suspend (nextInt: Key) -> Result<List<Item>>,
    private  inline  val getNextKey : suspend (List<Item>) -> Key
){
}