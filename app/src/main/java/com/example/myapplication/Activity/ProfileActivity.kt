package com.example.myapplication.Activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.Constants
import com.example.myapplication.R
import com.example.myapplication.showToast
import kotlinx.android.synthetic.main.activity_profile.*

class ProfileActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        val bundle: Bundle? = intent.extras

        //null safety
        bundle?.let {
            val msg = bundle.getString(Constants.USER_MSG_KEY)

            showToast(resources.getString(R.string.toast_login_success))
            txv_username.text = msg

        }
    }
}