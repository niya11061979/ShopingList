package com.example.shopinglist.domain

import androidx.lifecycle.LiveData

interface ShopListRepository {
    fun deleteItem(shopItem: ShopItem)
    fun addShopItem(shopItem: ShopItem)
    fun editShopItem(shopItem: ShopItem)
    fun getShopItem(shopItemId: Long): ShopItem
    fun getList(): LiveData<List<ShopItem>>
}