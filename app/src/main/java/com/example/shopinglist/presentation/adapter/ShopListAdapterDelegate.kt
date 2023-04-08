package com.example.shopinglist.presentation.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.shopinglist.databinding.ItemShopTrueBinding
import com.example.shopinglist.domain.ShopItem
import com.example.shopinglist.utils.inflate
import com.hannesdorfmann.adapterdelegates4.AbsListItemAdapterDelegate

class ShopListAdapterDelegate :
    AbsListItemAdapterDelegate<ShopItem, ShopItem, ShopListAdapterDelegate.Holder>() {
    override fun isForViewType(
        item: ShopItem,
        items: MutableList<ShopItem>,
        position: Int
    ): Boolean {
        return true
    }

    override fun onCreateViewHolder(parent: ViewGroup): Holder {
        return Holder(parent.inflate(ItemShopTrueBinding::inflate))
    }

    override fun onBindViewHolder(item: ShopItem, holder: Holder, payloads: MutableList<Any>) {
        holder.bind(item)
    }

    class Holder(
        private val binding: ItemShopTrueBinding,
    ) : RecyclerView.ViewHolder(binding.root) {

        init {

        }

        fun bind(item: ShopItem) {
            binding.nameShopTVT.text=item.name
            binding.countTVT.text=item.count.toString()
        }

    }
}