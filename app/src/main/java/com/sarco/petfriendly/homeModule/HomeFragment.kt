package com.sarco.petfriendly.homeModule

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import com.sarco.petfriendly.R
import com.sarco.petfriendly.common.entities.StoreEntity
import com.sarco.petfriendly.databinding.FragmentHomeBinding
import com.sarco.petfriendly.editModule.EditFragment
import com.sarco.petfriendly.homeModule.adapter.OnClickListener
import com.sarco.petfriendly.homeModule.adapter.StoresAdapter
import com.sarco.petfriendly.homeModule.viewModel.HomeViewModel

class HomeFragment : Fragment(), OnClickListener {

    private lateinit var mBinding: FragmentHomeBinding

    private lateinit var mFragment: Fragment
    private lateinit var mFragmentManager: FragmentManager

    private lateinit var mAdapter: StoresAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = FragmentHomeBinding.inflate(inflater, container, false)

        setupRecyclerView()
        return mBinding.root
    }


    private fun setupRecyclerView() {
        mAdapter = StoresAdapter(HomeViewModel().getStores() ,this)
        mBinding.recyclerStores.apply {
            adapter = mAdapter
        }

    }

    private fun goToEditFragment(storeEntity: StoreEntity){
        mFragmentManager = requireActivity().supportFragmentManager
        val editFragment = EditFragment()
        editFragment.arguments?.putInt("ID", storeEntity.id.toInt())
        mFragmentManager.beginTransaction().replace(R.id.main_frame_layout,
            editFragment).addToBackStack(null).commit()

    }

    override fun onClick(storeEntity: StoreEntity) {
        goToEditFragment(storeEntity)
    }
}