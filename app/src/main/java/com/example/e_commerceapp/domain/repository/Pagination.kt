package com.example.e_commerceapp.domain.repository

interface Pagination<Key, Item> {
    suspend fun loadNextItems()
    fun reset()

}