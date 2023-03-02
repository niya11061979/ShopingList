package com.example.shopinglist.domain

import androidx.lifecycle.LiveData

class GetShopListUseCase(private val repository: ShopListRepository) {
    fun getList(): LiveData<List<ShopItem>> {
        return repository.getList()
    }
}