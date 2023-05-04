package com.example.shopinglist.domain

data class ShopItem(
    val name: String,
    val count: Int,
    var enable: Boolean,
    var id: Long = UNDEFINED_ID
) {
    companion object {
        const val UNDEFINED_ID = -1L
    }
}
