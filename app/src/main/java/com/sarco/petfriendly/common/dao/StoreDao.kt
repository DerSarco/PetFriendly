package com.sarco.petfriendly.common.dao

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.sarco.petfriendly.common.entities.StoreEntity

class StoreDao {

    fun getAllStores(): MutableList<StoreEntity> {
        val storesData: MutableList<StoreEntity> = mutableListOf()
        for (item in 0..10){
            val store = StoreEntity(id = item.toLong(),
                            name = "Test $item",
                            description = "Lorem Ipsum test $item",
                            address = "Avenue Test $item",
                            country = "Country number $item",
                            author = "Charles num$item")
            storesData.add(store)
        }
        return storesData
    }
}