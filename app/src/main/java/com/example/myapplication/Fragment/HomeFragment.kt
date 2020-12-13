package com.example.myapplication.Fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.Adapter.CardAdapter
import com.example.myapplication.Adapter.HomeTabAdapter
import com.example.myapplication.Model.Filter
import com.example.myapplication.Model.ProductModel
import com.example.myapplication.Model.ProductResponse
import com.example.myapplication.R
import com.example.myapplication.api.RetrofitInstance
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_home_tab.tabRecycleLayout
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class HomeFragment : Fragment() {
    private var list = ArrayList<ProductModel>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpRecycleView()
        setUpRecycleViewCard()
        scrollUp()
        list.clear()
//        setUpViewPager()


    }

    private fun setUpRecycleView(){

        val layoutManager = LinearLayoutManager (context)
        layoutManager.orientation = GridLayoutManager.HORIZONTAL
        tabRecycleLayout.layoutManager = layoutManager

        val adapter = context?.let { HomeTabAdapter (it, Filter.menu) }
        tabRecycleLayout.adapter = adapter

    }

    private fun  setUpRecycleViewCard(){
        search_list.setHasFixedSize(true)
        search_list.layoutManager = LinearLayoutManager(this.context)
        RetrofitInstance.retrofit.getProduct(5, 0).enqueue(object : Callback<ProductResponse>{
            override fun onResponse(call: Call<ProductResponse>, response: Response<ProductResponse>) {
                val listResponse = response.body()?.data
                listResponse?.let { list.addAll(it) }
                val adapter = context?.let { CardAdapter(it, list) }
                search_list.adapter = adapter
            }
            override fun onFailure(call: Call<ProductResponse>, t: Throwable) {

            }

        })

//        val layoutManager = LinearLayoutManager (context)
//        search_list.layoutManager = layoutManager
//
//        val adapter = context?.let { CardAdapter (it, ProductName) }
//        search_list.adapter = adapter


        search_list.addOnScrollListener(object : RecyclerView.OnScrollListener(){
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                if (dy < 1)
                    fab.hide()
                else
                    fab.show()
            }
        })

    }
    private fun scrollUp(){
        fab.setOnClickListener{
            search_list.smoothScrollToPosition(0)
        }
    }



//
//    private fun setUpViewPager(){
//
//        val adapter = context?.let { HomePagerAdapter(childFragmentManager) }
//        viewPager.adapter = adapter
//        tabLayout.setupWithViewPager(viewPager)
//
//    }
}
