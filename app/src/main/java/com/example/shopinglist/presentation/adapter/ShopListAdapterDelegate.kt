package com.example.shopinglist.presentation.adapter

import android.annotation.SuppressLint
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.shopinglist.R
import com.example.shopinglist.domain.ShopItem
import com.hannesdorfmann.adapterdelegates4.AbsListItemAdapterDelegate


class ShopListAdapterDelegate(private val onItemClick: (position: Int) -> Unit) :
    AbsListItemAdapterDelegate<ShopItem, ShopItem, ShopListAdapterDelegate.Holder>() {

    override fun isForViewType(item: ShopItem, items: MutableList<ShopItem>, position: Int): Boolean {
        return true
    }

    override fun onBindViewHolder(
        item: ShopItem, holder: Holder, payloads: MutableList<Any>
    ) {
        holder.bind(item)
    }

    override fun onCreateViewHolder(parent: ViewGroup): Holder {
        return Holder(parent.)
    }

    class Holder(
        containerView: View, onItemClick: (position: Int) -> Unit
    ) : RecyclerView.ViewHolder(containerView) {
        init {
            containerView.setOnClickListener { onItemClick(adapterPosition) }
        }

        private val binding = RepositoryInformationBinding.bind(containerView)


        fun bind(shopItem: ShopItem) {


        }
    }
}