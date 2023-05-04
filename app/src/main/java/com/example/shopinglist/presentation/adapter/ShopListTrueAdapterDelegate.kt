package com.example.shopinglist.presentation.adapter

import android.util.Log
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.shopinglist.databinding.ItemShopTrueBinding
import com.example.shopinglist.domain.ShopItem
import com.example.shopinglist.utils.inflate
import com.hannesdorfmann.adapterdelegates4.AbsListItemAdapterDelegate

class ShopListTrueAdapterDelegate(
    private val onLongClickItem: (item:ShopItem) -> Unit,
    private val onClickItem: (cardView: CardView, id: Long) -> Unit
) :
    AbsListItemAdapterDelegate<ShopItem, ShopItem, ShopListTrueAdapterDelegate.Holder>() {
    override fun isForViewType(
        item: ShopItem,
        items: MutableList<ShopItem>,
        position: Int
    ): Boolean {
        return item.enable
    }

    override fun onCreateViewHolder(parent: ViewGroup): Holder {
        return Holder(parent.inflate(ItemShopTrueBinding::inflate), onLongClickItem, onClickItem)
    }

    override fun onBindViewHolder(item: ShopItem, holder: Holder, payloads: MutableList<Any>) {
        holder.bind(item)
    }

    class Holder(
        private val binding: ItemShopTrueBinding,
        private val onLongClickItem: (item: ShopItem) -> Unit,
        private val onClickItem: (cardView: CardView, id: Long) -> Unit
    ) : RecyclerView.ViewHolder(binding.root) {
        private var currentCardView: CardView? = null
        private var currentItem: ShopItem? = null

        init {
            binding.cardShopTrue.setOnClickListener {
                currentItem?.let { it1 -> onLongClickItem(it1) }
            }
        }

        fun bind(item: ShopItem) {
            currentItem=item
            binding.nameShopTVT.text = item.enable.toString()
            binding.countTVT.text = item.count.toString()
        }


    }
}

