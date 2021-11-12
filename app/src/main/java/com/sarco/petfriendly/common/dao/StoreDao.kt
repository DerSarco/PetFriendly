package com.sarco.petfriendly.common.dao

import android.content.res.Resources
import com.sarco.petfriendly.R
import com.sarco.petfriendly.common.entities.StoreEntity

class StoreDao {

    fun getAllStores(resources: Resources): MutableList<StoreEntity> {
        val storesData: MutableList<StoreEntity> = mutableListOf()

        for (item in 0..10){
            var country = "Chile"
            if(item % 3 == 0 ){
               country = resources.getStringArray(R.array.countries)[1].toString()
            }
            val store = StoreEntity(id = item.toLong(),
                            name = "Test $item",
                            description = "Lorem Ipsum test $item",
                            address = "Avenue Test $item",
                            country = country,
                            author = "Charles num$item")
            storesData.add(store)
        }
        return storesData
    }
}