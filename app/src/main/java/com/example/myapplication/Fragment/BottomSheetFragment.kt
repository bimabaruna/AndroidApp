package com.example.myapplication.Fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.example.myapplication.Activity.BookingFormActivity
import com.example.myapplication.Constants
import com.example.myapplication.R
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kotlinx.android.synthetic.main.layout_bottom_sheet.view.*

open class BottomSheetFragment : BottomSheetDialogFragment(){

     private var fragmentView : View? = null

     override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(DialogFragment.STYLE_NORMAL, R.style.BottomSheetDialogTheme)

    }

    override fun onCreateView(layoutinflater : LayoutInflater,container: ViewGroup?, savedInstanceState: Bundle?): View? {
        fragmentView = layoutinflater.inflate(R.layout.layout_bottom_sheet,container, false)
        return fragmentView

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val bundle : Bundle? = arguments

        bundle.let {
            val pm = bundle?.getString(Constants.PRODUCT_NAME).toString()
            val price = bundle?.getString(Constants.PRODUCT_PRICE).toString()
            view.product_name_bottomSheet.text = pm
            view.product_price_bottomSheet.text = price

        }

        view.buttonBottomSheet.setOnClickListener{
            val intent = Intent(view.context, BookingFormActivity::class.java)
            startActivity(intent)

        }

    }

 }