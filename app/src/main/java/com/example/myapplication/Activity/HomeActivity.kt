package com.example.myapplication.Activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.Adapter.HomeAdapter
import com.example.myapplication.Adapter.HomePagerAdapter
import com.example.myapplication.Model.Filter
import com.example.myapplication.R
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.tab_homepage.*

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.tab_homepage)
        setUpViewPager()
//        setContentView(R.layout.activity_home)
//        setupRecycleView()
    }

    private fun setupRecycleView() {
        val layoutManager = LinearLayoutManager(this)
        layoutManager.orientation = GridLayoutManager.HORIZONTAL
        homeRecycleLayout.layoutManager = layoutManager

        val adapter = HomeAdapter(this, Filter.menu)
        homeRecycleLayout.adapter = adapter
    }

    private fun setUpViewPager(){

        val adapter = HomePagerAdapter(supportFragmentManager)
        viewPager.adapter = adapter
        tabLayout.setupWithViewPager(viewPager)

    }


}



