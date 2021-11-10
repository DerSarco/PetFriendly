package com.sarco.petfriendly.editModule

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.sarco.petfriendly.R
import com.sarco.petfriendly.databinding.FragmentEditBinding

class EditFragment : Fragment() {

    private lateinit var mBinding: FragmentEditBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = FragmentEditBinding.inflate(inflater, container, false)
        return mBinding.root
    }

}