package com.sarco.petfriendly.editModule.adapter

import android.content.Context
import android.view.ViewParent
import android.widget.ArrayAdapter
import android.widget.Spinner
import com.sarco.petfriendly.R

class SpinnerAdapter() {


    fun arrayAdapter(spinner: Spinner, context: Context){
        ArrayAdapter.createFromResource(
            context,
            R.array.countries,
            android.R.layout.simple_spinner_dropdown_item
        ).also { adapter ->
            // Specify the layout to use when the list of choices appears
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            // Apply the adapter to the spinner
            spinner.adapter = adapter
        }
    }
}