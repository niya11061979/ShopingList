package com.example.shopinglist.domain

interface ShopListRepository {
    fun deleteItem(shopItem: ShopItem)
    fun addShopItem(shopItem: ShopItem)
    fun editShopItem(shopItem: ShopItem)
    fun getShopItem(shopItemId: Int): ShopItem
    fun getList(): List<ShopItem>
}