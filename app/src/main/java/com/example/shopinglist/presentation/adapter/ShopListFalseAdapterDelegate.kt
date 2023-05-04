package com.example.shopinglist.presentation.adapter

import android.util.Log
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.shopinglist.databinding.ItemShopFalseBinding
import com.example.shopinglist.domain.ShopItem
import com.example.shopinglist.utils.inflate
import com.hannesdorfmann.adapterdelegates4.AbsListItemAdapterDelegate

class ShopListFalseAdapterDelegate(
    private val onLongClickItem: (item: ShopItem) -> Unit,
    private val onClickItem: (cardView: CardView, id: Long) -> Unit,

) :
    AbsListItemAdapterDelegate<ShopItem, ShopItem, ShopListFalseAdapterDelegate.Holder>() {


    override fun isForViewType(
        item: ShopItem,
        items: MutableList<ShopItem>,
        position: Int
    ): Boolean {
        return !item.enable
    }

    override fun onCreateViewHolder(parent: ViewGroup): Holder {

        return Holder(parent.inflate(ItemShopFalseBinding::inflate), onLongClickItem, onClickItem)
    }

    override fun onBindViewHolder(item: ShopItem, holder: Holder, payloads: MutableList<Any>) {
        holder.bind(item)
    }

    class Holder(
        private val binding: ItemShopFalseBinding,
        private val onLongClickItem: (item:ShopItem) -> Unit,
        private val onClickItem: (cardView: CardView, id: Long) -> Unit
    ) : RecyclerView.ViewHolder(binding.root) {

        private var currentCardView: CardView? = null
        private var currentItem: ShopItem? = null


        init {
            binding.cardShop.setOnClickListener {
                currentItem?.let { it1 -> onLongClickItem(it1) }

            }
        }

        fun bind(item: ShopItem) {
            currentItem=item
            binding.nameShopTextView.text = item.enable.toString()
            binding.countTextView.text = item.count.toString()
        }

    }
}

