package com.example.shopinglist.domain

class GetShopListUseCase(private val repository: ShopListRepository) {
    fun getList(): List<ShopItem> {
        return repository.getList()
    }
}