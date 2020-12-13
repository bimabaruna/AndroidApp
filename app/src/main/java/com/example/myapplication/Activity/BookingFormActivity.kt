package com.example.myapplication.Activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.R
import com.google.android.gms.maps.GoogleMap
import kotlinx.android.synthetic.main.activity_booking_form.*

class BookingFormActivity : AppCompatActivity() {
    private lateinit var googleMap : GoogleMap
    private var count1 = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_booking_form)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        runOnClickListenerIncreaseDecrease()

        edit.setOnClickListener{
            val intent = Intent(it.context, MapsActivity::class.java)
            startActivity(intent)
        }

    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
        
    }

    private fun runOnClickListenerIncreaseDecrease(){
        increase_button.setOnClickListener{
            increase()

        }

        decrease_button.setOnClickListener{
            decrease()

        }

    }
    private fun increase (){
        count1 = (count1 + 1).coerceAtMost(10)
        number.text = count1.toString()
        if (number.text.toString().toInt() >1)
            decrease_button.isEnabled = true
        if (number.text.toString().toInt() == 10)
            increase_button.isEnabled = false
        if (number.text.toString().toInt() >1)
            decrease_button.setBackgroundResource(R.drawable.ic_minus)
        if (number.text.toString().toInt() == 10)
            increase_button.setBackgroundResource(R.drawable.ic_plus_disable)

    }
    private fun decrease (){
        count1 = (count1 - 1).coerceAtLeast(1)
        number.text = count1.toString()
        if (number.text.toString().toInt() == 1)
            decrease_button.isEnabled = false
        if (number.text.toString().toInt() < 10)
            increase_button.isEnabled = true
        if (number.text.toString().toInt() == 1)
            decrease_button.setBackgroundResource(R.drawable.ic_minus_disable)
        if (number.text.toString().toInt() < 10)
            increase_button.setBackgroundResource(R.drawable.ic_plus)

    }

}
