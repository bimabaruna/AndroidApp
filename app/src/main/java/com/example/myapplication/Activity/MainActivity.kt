package com.example.myapplication.Activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.myapplication.Fragment.AccountFragment
import com.example.myapplication.Fragment.HomeFragment
import com.example.myapplication.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    companion object {
        val TAG: String = MainActivity::class.java.simpleName

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val homeFragment = HomeFragment()
        val accountFragment = AccountFragment()




        makeCurrentFragment (accountFragment)

        bottom_navigation.setOnNavigationItemSelectedListener {
            when (it.itemId){
                R.id.ic_home -> makeCurrentFragment(homeFragment)


                R.id.ic_account -> makeCurrentFragment(accountFragment)
            }
            true
        }
    }

    private fun makeCurrentFragment( fragment: Fragment)=
            supportFragmentManager.beginTransaction().setCustomAnimations( R.anim.faded_enter, R.anim.faded_out, R.anim.faded_out,R.anim.faded_enter).apply {
            replace(R.id.fl_wrapper, fragment)
            commit()
        }

}
