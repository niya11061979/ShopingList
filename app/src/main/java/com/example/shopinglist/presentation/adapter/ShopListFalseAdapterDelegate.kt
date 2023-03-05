package com.example.shopinglist.presentation.adapter

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.shopinglist.R
import com.example.shopinglist.databinding.ItemShopFalseBinding
import com.example.shopinglist.domain.ShopItem
import com.hannesdorfmann.adapterdelegates4.AbsListItemAdapterDelegate
import com.example.shopinglist.utils.inflate


class ShopListFalseAdapterDelegate(private val onItemClick: (position: Int) -> Unit):
    AbsListItemAdapterDelegate<ShopItem, ShopItem, ShopListFalseAdapterDelegate.Holder>() {

    override fun isForViewType(
        item: ShopItem,
        items: MutableList<ShopItem>,
        position: Int
    ): Boolean {
        return true
    }

    override fun onCreateViewHolder(parent: ViewGroup): Holder {
        return Holder(parent.inflate(R.layout.item_shop_false), onItemClick )
    }

    override fun onBindViewHolder(
        item: ShopItem,
        holder: Holder,
        payloads: MutableList<Any>
    ) {
        holder.bind(item)
    }


    class Holder(
        containerView: View, onItemClick: (position: Int) -> Unit
    ) : RecyclerView.ViewHolder(containerView) {
        init {
            containerView.setOnClickListener { onItemClick(adapterPosition) }
        }
        private var binding=ItemShopFalseBinding.bind(containerView)

        fun bind(shopItem: ShopItem) {
            binding.nameShopTextView.text = shopItem.name
            binding.countTextView.text = shopItem.count.toString()
        }
    }
}