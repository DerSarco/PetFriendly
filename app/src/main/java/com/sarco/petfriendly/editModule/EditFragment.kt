package com.sarco.petfriendly.editModule

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.result.contract.ActivityResultContracts.*
import androidx.fragment.app.Fragment
import com.sarco.petfriendly.R
import com.sarco.petfriendly.common.dao.StoreDao
import com.sarco.petfriendly.common.entities.StoreEntity
import com.sarco.petfriendly.databinding.FragmentEditBinding
import com.sarco.petfriendly.editModule.adapter.DropDownAdapter
import com.sarco.petfriendly.editModule.adapter.OnClickListener
import com.sarco.petfriendly.mainModule.MainActivity

class EditFragment : Fragment(){

    companion object{
        const val STORE_ID = "STORE_ID"
        const val IS_EDIT = "IS_EDIT"
        const val IMAGE_PICK = "image/*"

    }

    private lateinit var mBinding: FragmentEditBinding

    private lateinit var mActivity: MainActivity

    private val mIsEdit by lazy {
        requireArguments().getBoolean(IS_EDIT)
    }
    private var storeInfo: StoreEntity? = null



    private val resultFromActivty =registerForActivityResult(GetContent()) { uri ->
        mBinding.ivPhotoPreview.setImageURI(uri)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = FragmentEditBinding.inflate(inflater, container, false)
        val storeId = requireArguments().getLong(STORE_ID)
        if(mIsEdit){
            storeInfo = StoreDao().getAllStores(resources).find { store ->
                store.id == storeId
            }
        }
        if(storeInfo !== null){
            setupStoreData(storeInfo)
        }

        setupSpinner()
        setupActionBar()
        setupActionButtons()
        return mBinding.root

    }

    private fun setupActionButtons() {
        mBinding.btnPhoto.setOnClickListener{
            resultFromActivty.launch(IMAGE_PICK)
        }
    }

    private fun setupActionBar() {
        mActivity = activity as MainActivity
        mActivity.supportActionBar?.setDisplayHomeAsUpEnabled(true)
        mActivity.supportActionBar?.title = if(mIsEdit)
                                                getString(R.string.title_edit)
                                            else
                                                getString(R.string.title_create)
        setHasOptionsMenu(true)
    }



    private fun setupStoreData(storeInfo: StoreEntity?) {
        mBinding.tiStoreName.setText(storeInfo?.name)
        mBinding.tiStoreAddress.setText(storeInfo?.address)
        storeInfo.let { store ->
            mBinding.dropDownCountries.setText(store?.country.toString())
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_save_store, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            android.R.id.home -> {
                mActivity.onBackPressed()
                true
            }
            R.id.menu_save_store -> {
                saveStore()
                true
            }
        }

        return super.onOptionsItemSelected(item)
    }



    private fun setupSpinner() {
        val dropDown = mBinding.dropDownCountries
        val countries = resources.getStringArray(R.array.countries)
        DropDownAdapter().arrayAdapter(dropDown, this.requireContext(), countries)

    }

    override fun onResume() {
        super.onResume()
        setupSpinner()
    }

    fun saveStore(){
        val editMode = requireArguments().getBoolean(IS_EDIT)
        if(editMode)
            showToast("Editable")
        else
            showToast("No Editable")

    }

    override fun onDestroy() {
        mActivity.let {
            it.supportActionBar?.setDisplayHomeAsUpEnabled(false)
            it.supportActionBar?.title = getString(R.string.app_name)
            it.bottomNavBar()
        }

        super.onDestroy()
    }
    private fun showToast(string: String, context: Context = requireContext()){
        Toast.makeText(context, string, Toast.LENGTH_SHORT).show()
    }

}