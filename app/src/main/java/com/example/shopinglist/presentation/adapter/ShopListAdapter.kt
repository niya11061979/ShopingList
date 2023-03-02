package com.example.shopinglist.presentation.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.shopinglist.domain.ShopItem
import com.hannesdorfmann.adapterdelegates4.AsyncListDifferDelegationAdapter


class ShopListAdapter(
    onItemClick: (position: Int) -> Unit):  AsyncListDifferDelegationAdapter<ShopItem>(
    RepositoryDiffUtilCallback()
) {

    init {
        delegatesManager.addDelegate(ShopListAdapterDelegate(onItemClick))
    }

    class RepositoryDiffUtilCallback : DiffUtil.ItemCallback<ShopItem>() {
        //    Сравнивает два элемента на основании какого-либо индентификатора
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
