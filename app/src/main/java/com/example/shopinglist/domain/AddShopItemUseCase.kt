package com.example.shopinglist.domain

class AddShopItemUseCase(private val repository: ShopListRepository) {
    fun addShopItem(shopItem: ShopItem): ShopItem {
    return repository.addShopItem(shopItem)
    }
}