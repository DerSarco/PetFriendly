package com.sarco.petfriendly.editModule.adapter

import android.content.Context
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import com.sarco.petfriendly.R
import com.sarco.petfriendly.common.entities.StoreEntity

class DropDownAdapter() {


    fun arrayAdapter(dropDown: AutoCompleteTextView, context: Context, resources: Array<String>){
        ArrayAdapter(
            context,
            R.layout.item_dropdown,
            resources
        ).also<ArrayAdapter<String>>(dropDown::setAdapter)

    }
}