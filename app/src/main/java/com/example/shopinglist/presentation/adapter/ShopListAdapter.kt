package com.example.shopinglist.presentation.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.shopinglist.domain.ShopItem
import com.hannesdorfmann.adapterdelegates4.AsyncListDifferDelegationAdapter


class ShopListAdapter(
    onItemClick: (position: Int) -> Unit
) : AsyncListDifferDelegationAdapter<ShopItem>(
    ShopListDiffUtilCallback()
) {

    init {
        delegatesManager.addDelegate(ShopListTrueAdapterDelegate(onItemClick))
            .addDelegate(ShopListFalseAdapterDelegate(onItemClick))
    }

    class ShopListDiffUtilCallback : DiffUtil.ItemCallback<ShopItem>() {
        //    Сравнивает два элемента на основании индентификатора
        override fun areItemsTheSame(
            oldItem: ShopItem,
            newItem: ShopItem
        ): Boolean {
            return oldItem.id == newItem.id
        }

        //    Проверяет совпадает ли содержание двух элементов. Метод будет вызван после того как метод выше вернет true
        override fun areContentsTheSame(
            oldItem: ShopItem,
            newItem: ShopItem
        ): Boolean {
            return oldItem == newItem
        }
    }
}
