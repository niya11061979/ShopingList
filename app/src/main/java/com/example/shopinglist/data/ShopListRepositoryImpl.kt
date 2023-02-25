package com.example.shopinglist.data

import com.example.shopinglist.domain.ShopItem
import com.example.shopinglist.domain.ShopListRepository

object ShopListRepositoryImpl : ShopListRepository {

    private val shopList = mutableListOf<ShopItem>()
    private var autoIncrementId = 0
    override fun addShopItem(shopItem: ShopItem) {
        if (shopItem.id == ShopItem.UNDEFINED_ID) {
            autoIncrementId++
            shopItem.id = autoIncrementId
        }
        shopList.add(shopItem)
    }

    fun deleteItem(shopItem: ShopItem) {
        shopList.remove(shopItem)
    }

    override fun editShopItem(shopItem: ShopItem) {
        val oldItem = getShopItem(shopItem.id)
        shopList.remove(oldItem)
        addShopItem(shopItem)
    }

    override fun getShopItem(shopItemId: Int): ShopItem {
        return shopList.find { it.id == shopItemId }
            ?: throw RuntimeException("Shop with id=$shopItemId not found")
    }

    override fun getList(): List<ShopItem> {
        TODO("Not yet implemented")
    }
}