package com.example.myapplication.Activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.R
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class MapsActivity : AppCompatActivity() {

    lateinit var mapFragment : SupportMapFragment
    lateinit var googleMap : GoogleMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        mapFragment = supportFragmentManager.findFragmentById(R.id.maps) as SupportMapFragment
        mapFragment.getMapAsync(OnMapReadyCallback {
            googleMap = it

            val location1 = LatLng(-6.3150197,106.6740118)
            googleMap.addMarker(MarkerOptions().position(location1).title("Our Outlet"))
            googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(location1, 15f))
        })
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }
}
