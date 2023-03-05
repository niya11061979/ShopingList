package com.example.shopinglist.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.shopinglist.databinding.ShopListFragmentBinding
import com.example.shopinglist.presentation.adapter.ShopListAdapter
import com.example.shopinglist.utils.ItemOffsetDecoration
import com.example.shopinglist.utils.ViewBindingFragment
import com.example.shopinglist.utils.autoCleared


class ShopListFragment :
    ViewBindingFragment<ShopListFragmentBinding>(ShopListFragmentBinding::inflate) {
    private var shopListAdapter: ShopListAdapter by autoCleared()
    private val viewModel: MainViewModel by viewModels()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initList()
        bindViewModel()
    }


    private fun bindViewModel() {

    }

    private fun initList() {
        shopListAdapter = ShopListAdapter(::onLongClickImage)
        with(binding.rvShopList) {
            setHasFixedSize(true)
            adapter = shopListAdapter
            setHasFixedSize(true)
            //this?.itemAnimator = ScaleInAnimator()  //применим аниматор
        }
    }

    private fun onLongClickImage(i: Int) {

    }

}