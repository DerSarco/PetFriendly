package com.sarco.petfriendly.homeModule.viewModel

import android.content.res.Resources
import com.sarco.petfriendly.common.dao.StoreDao
import com.sarco.petfriendly.common.entities.StoreEntity

class HomeViewModel {

    fun getStores(resources: Resources): MutableList<StoreEntity> {
        return StoreDao().getAllStores(resources)
    }
}