package com.example.shopinglist.presentation.adapter

import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.DiffUtil
import com.example.shopinglist.domain.ShopItem
import com.hannesdorfmann.adapterdelegates4.AsyncListDifferDelegationAdapter

class ShopListAdapter(
    onLongClickImage: (item: ShopItem) -> Unit,
    onClickImage: (cardView: CardView, id: Long) -> Unit
) : AsyncListDifferDelegationAdapter<ShopItem>(ShopListDiffUtilCallback()) {

    init {
        with(delegatesManager) {
            addDelegate(ShopListTrueAdapterDelegate(onLongClickImage,onClickImage))
            addDelegate((ShopListFalseAdapterDelegate(onLongClickImage,onClickImage)))
        }
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

