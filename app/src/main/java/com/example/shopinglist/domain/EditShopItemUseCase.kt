package com.example.shopinglist.domain

class EditShopItemUseCase(private val repository: ShopListRepository) {
    fun editShopItem(shopItem: ShopItem){
      return repository.editShopItem(shopItem)
    }
}