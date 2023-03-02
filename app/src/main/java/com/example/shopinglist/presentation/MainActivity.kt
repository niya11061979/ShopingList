package com.example.shopinglist.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.widget.LinearLayout
import androidx.lifecycle.ViewModelProvider
import com.example.shopinglist.R
import com.example.shopinglist.domain.ShopItem

class MainActivity : AppCompatActivity() {
    private var count = 0
    private lateinit var viewModel: MainViewModel
    private lateinit var llShopList:LinearLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        viewModel.shopList.observe(this) { list -> showList(list) }
    }

    private fun showList(list: List<ShopItem>) {
       for (shopItemId in list){

           val layout=if (shopItemId.enable){
               R.layout.item_shop_true
           }else{
               R.layout.item_shop_false
           }
           val linearLayout=findViewById<LinearLayout>(R.id.rv_shop_list)
           //val view=LayoutInflater.from(this).inflate()
       }
    }
}