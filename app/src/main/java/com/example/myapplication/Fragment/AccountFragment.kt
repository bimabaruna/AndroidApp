package com.example.myapplication.Fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.myapplication.Activity.HomeActivity
import com.example.myapplication.Activity.ProfileActivity
import com.example.myapplication.Constants
import com.example.myapplication.R
import kotlinx.android.synthetic.main.fragment_account.*

/**
 * A simple [Fragment] subclass.
 */
class AccountFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_account, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btn_login.setOnClickListener{
            val message: String = et_username.text.toString()



            val intent = Intent(view.context, ProfileActivity::class.java)
            intent.putExtra(Constants.USER_MSG_KEY, message)
            startActivity(intent)
        }

        btn_Home.setOnClickListener {
            val intent = Intent(view.context, HomeActivity::class.java)
            startActivity(intent)
        }
    }



}
