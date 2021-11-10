package com.sarco.petfriendly.homeModule.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.sarco.petfriendly.R
import com.sarco.petfriendly.common.entities.StoreEntity
import com.sarco.petfriendly.databinding.ItemStoreBinding
import com.sarco.petfriendly.homeModule.HomeFragment
import kotlin.properties.Delegates


class StoresAdapter(storeList: MutableList<StoreEntity>,
                    private var listener: OnClickListener):
    RecyclerView.Adapter<StoresAdapter.ViewHolder>(){

    private lateinit var mContext: Context

    private var storeList: MutableList<StoreEntity> by Delegates.observable(storeList){ _,_,_ ->
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        mContext = parent.context

        val view = LayoutInflater.from(mContext).inflate(R.layout.item_store,
            parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val store = storeList[position]
        with(holder){
            setListener(store)
            with(binding){
                tvStoreTitle.text = store.name
                tvStoreDescription.text = store.description
                Glide.with(mContext)
                    .load("https://placekitten.com/200/300")
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .centerCrop()
                    .into(ivStorePhoto)
            }
        }
    }

    inner class ViewHolder(view: View): RecyclerView.ViewHolder(view){

        val binding = ItemStoreBinding.bind(view)

        fun setListener(storeEntity: StoreEntity){
            with(binding.root){
                setOnClickListener{
                   listener.onClick(storeEntity)
                }
            }
        }

    }

    override fun getItemCount(): Int = storeList.size

}