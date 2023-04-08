package com.example.shopinglist.presentation.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.shopinglist.domain.ShopItem
import com.hannesdorfmann.adapterdelegates4.AsyncListDifferDelegationAdapter

class ShopListAdapter : AsyncListDifferDelegationAdapter<ShopItem>(ShopListDiffUtilCallback()) {

    init {
        delegatesManager.addDelegate(ShopListAdapterDelegate())
    }

    class ShopListDiffUtilCallback : DiffUtil.ItemCallback<ShopItem>() {
        override fun areItemsTheSame(oldItem: ShopItem, newItem: ShopItem): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: ShopItem, newItem: ShopItem): Boolean {
            return oldItem == newItem
        }
    }
}