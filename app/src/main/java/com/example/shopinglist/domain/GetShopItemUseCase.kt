package com.example.shopinglist.domain

class GetShopItemUseCase(private val repository: ShopListRepository) {
    fun getShopItem(shopItemId: Long): ShopItem {
      return repository.getShopItem(shopItemId)
    }
}