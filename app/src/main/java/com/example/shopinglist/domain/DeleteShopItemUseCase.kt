package com.example.shopinglist.domain

class DeleteShopItemUseCase(private val repository: ShopListRepository) {
    fun deleteItem(shopItem: ShopItem): ShopItem {
      return repository.deleteItem(shopItem)
    }
}