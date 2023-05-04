package com.example.shopinglist.presentation

import android.os.Bundle
import android.view.View
import androidx.cardview.widget.CardView
import androidx.fragment.app.viewModels
import com.example.shopinglist.databinding.ShopListFragmentBinding
import com.example.shopinglist.domain.ShopItem
import com.example.shopinglist.presentation.adapter.ShopListAdapter
import com.example.shopinglist.utils.ItemOffsetDecoration
import com.example.shopinglist.utils.ViewBindingFragment
import com.example.shopinglist.utils.autoCleared


class ShopListFragment :
    ViewBindingFragment<ShopListFragmentBinding>(ShopListFragmentBinding::inflate) {
    private var shopListAdapter: ShopListAdapter by autoCleared()
    private val viewModel: MainViewModel by viewModels()
    private var currentList = listOf<ShopItem>()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initList()
        bindViewModel()
    }


    private fun bindViewModel() {
        viewModel.shopList.observe(viewLifecycleOwner) {
            shopListAdapter.items = it
            currentList = it
        }
    }

    private fun initList() {
        shopListAdapter = ShopListAdapter(::onLongClickItem, ::onClickItem)
        with(binding.shopList) {
            setHasFixedSize(true)
            adapter = shopListAdapter
        }
    }

    private fun onClickItem(cardView: CardView, id: Long) {

    }

    private fun onLongClickItem(item: ShopItem) {
        viewModel.changeEnableState(item)
    }
}


