package com.sarco.petfriendly.homeModule

import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.google.android.material.snackbar.Snackbar
import com.sarco.petfriendly.R
import com.sarco.petfriendly.common.entities.StoreEntity
import com.sarco.petfriendly.databinding.FragmentHomeBinding
import com.sarco.petfriendly.editModule.EditFragment
import com.sarco.petfriendly.homeModule.adapter.OnClickListener
import com.sarco.petfriendly.homeModule.adapter.StoresAdapter
import com.sarco.petfriendly.homeModule.viewModel.HomeViewModel
import com.sarco.petfriendly.mainModule.MainActivity

class HomeFragment : Fragment(), OnClickListener {

    private lateinit var mBinding: FragmentHomeBinding

    private lateinit var mFragmentManager: FragmentManager

    private lateinit var mActivity: MainActivity

    private lateinit var mAdapter: StoresAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = FragmentHomeBinding.inflate(inflater, container, false)

        setupRecyclerView()
        setHasOptionsMenu(true)
        mActivity = activity as MainActivity
        return mBinding.root
    }


    private fun setupRecyclerView() {
        mAdapter = StoresAdapter(HomeViewModel().getStores(resources) ,this)
        mBinding.recyclerStores.apply {
            adapter = mAdapter
        }

    }


    private fun goToEditFragment(){
        mFragmentManager = requireActivity().supportFragmentManager
        val editFragment = EditFragment()
        val bundle = Bundle()
        bundle.putBoolean("IS_EDIT", false)
        editFragment.arguments = bundle
        mFragmentManager.beginTransaction().replace(R.id.main_frame_layout,
            editFragment).addToBackStack(null).commit()
        mActivity.bottomNavBar()

    }

    override fun onClick(storeEntity: StoreEntity) {
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        goToEditFragment()
        return super.onOptionsItemSelected(item)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_add_store, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }
}