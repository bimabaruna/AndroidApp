package com.example.myapplication.Adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.Model.Food
import com.example.myapplication.R
import com.example.myapplication.showToast
import kotlinx.android.synthetic.main.list_home_item.view.*

class HomeAdapter(val context: Context, val Menu: List<Food>) : RecyclerView.Adapter<HomeAdapter.MyViewHolder>() {

    inner class MyViewHolder (itemView : View): RecyclerView.ViewHolder(itemView){

        var currentFood : Food? = null
                var currentPosition : Int = 0

        init {
            itemView.setOnClickListener {
                context.showToast(currentFood!!.title + " Clicked! ", Toast.LENGTH_LONG)


            }
                itemView.imgShare.setOnClickListener {
                    val message : String = "My Choose is " + currentFood!!.title
                    val intent = Intent()
                    intent.action = Intent.ACTION_SEND
                    intent.putExtra(Intent.EXTRA_TEXT, message)
                    intent.type = "text/plain"

                    context.startActivities(arrayOf(Intent.createChooser(intent , "Please select!" )))
                }
        }

        fun setData (menu: Food?, position : Int){

           //null safety
            menu?.let {
                itemView.txvTitle.text = menu.title
            }

            this.currentFood = menu
            this.currentPosition = position
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.list_home_item, parent, false)
        return MyViewHolder(view)

    }

    override fun getItemCount(): Int {
        return Menu.size

    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val menu = Menu[position]
        holder.setData(menu, position)
    }
}
