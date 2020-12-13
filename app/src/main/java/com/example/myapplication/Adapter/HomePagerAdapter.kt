package com.example.myapplication.Adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.myapplication.FragmentHomeTab
import com.example.myapplication.FragmentHomeTab2
import com.example.myapplication.FragmentHometab3

class HomePagerAdapter (fm : FragmentManager) :  FragmentPagerAdapter (fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    private val fragmentList :List<Fragment> = listOf(

        FragmentHomeTab(),
        FragmentHomeTab2(),
        FragmentHometab3()
    )


    override fun getItem(position: Int): Fragment {
        return fragmentList [position]

        }


    override fun getCount(): Int {
        return fragmentList.size

    }

    override fun getPageTitle(position: Int): CharSequence? {
        return when (position){
            0->"One"
            1->"Two"
            else -> "Three"
        }

    }

}


