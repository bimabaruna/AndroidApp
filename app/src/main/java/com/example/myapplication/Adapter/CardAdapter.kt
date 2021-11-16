package com.example.myapplication.Adapter

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ToggleButton
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.Constants
import com.example.myapplication.Fragment.BottomSheetFragment
import com.example.myapplication.Model.ProductModel
import com.example.myapplication.R
import com.example.myapplication.Title
import kotlinx.android.synthetic.main.product_card.view.*

class CardAdapter(private val context : Context, private val list: ArrayList<ProductModel>)  : RecyclerView.Adapter<CardAdapter.MyViewHolder>() {

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var currentTitle: Title? = null
        var currentPosition: Int = 0
        private val favToggle : ToggleButton = itemView.findViewById(R.id.fav_toogle)
        private val buy : Button = itemView.findViewById(R.id.button_buy)


        fun setData(newList : ProductModel) {
            with(itemView){
                val text = newList.productName
                val price = newList.price
                product_price.text = "Rp.$price"
                product_name.text= text
            }
//            this.currentTitle = menu
//            this.currentPosition = position
//            menu?.let {
//                itemView.product_name.text = menu.title
//            }
        }

        init {
            favToggle.setOnClickListener{
                if (favToggle.isChecked){
                    favToggle.setBackgroundResource(R.drawable.ic_favorite)
                }else{
                    favToggle.setBackgroundResource(R.drawable.ic_favorite_uncheck)
                }
            }

            buy.setOnClickListener {
                val fragment  = BottomSheetFragment()
                val fragmentManager = (context as AppCompatActivity).supportFragmentManager.beginTransaction()
                val bundle  = Bundle()
                val pm : String = itemView.product_name.text.toString()
                val price : String = itemView.product_price.text.toString()
                bundle.putString(Constants.PRODUCT_NAME, pm)
                bundle.putString(Constants.PRODUCT_PRICE, price)
                fragment.arguments = bundle
                fragment.show(fragmentManager, fragment.tag)

            }
       }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardAdapter.MyViewHolder {
       val view = LayoutInflater.from(context).inflate(R.layout.product_card, parent, false)
        return MyViewHolder(view)
    }


    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.setData(list[position])
//        val menu = Menu[position]
//        holder.setData(menu, position)
    }
}