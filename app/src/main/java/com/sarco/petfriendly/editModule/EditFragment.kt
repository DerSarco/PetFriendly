package com.sarco.petfriendly.editModule

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.sarco.petfriendly.R
import com.sarco.petfriendly.databinding.FragmentEditBinding
import com.sarco.petfriendly.editModule.adapter.SpinnerAdapter

class EditFragment : Fragment(){

    private lateinit var mBinding: FragmentEditBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = FragmentEditBinding.inflate(inflater, container, false)
        setupSpinner()
        return mBinding.root
    }

    private fun setupSpinner() {
        val spinner = mBinding.spinnerCountry
        SpinnerAdapter().arrayAdapter(spinner, this.requireContext())
    }

}