package com.example.myapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.Adapter.HomeTabAdapter
import com.example.myapplication.Model.Filter
import kotlinx.android.synthetic.main.fragment_home_tab.*


class FragmentHomeTab : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_home_tab, container, false)



    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpRecycleView()




    }

    private fun setUpRecycleView (){
        val layoutManager = LinearLayoutManager(context)
        layoutManager.orientation = GridLayoutManager.HORIZONTAL
        tabRecycleLayout.layoutManager = layoutManager

        val adapter = context?.let { HomeTabAdapter(it, Filter.menu) }
        tabRecycleLayout.adapter = adapter

    }

}
