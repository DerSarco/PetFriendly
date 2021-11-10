package com.sarco.petfriendly.homeModule.viewModel

import com.sarco.petfriendly.common.dao.StoreDao
import com.sarco.petfriendly.common.entities.StoreEntity

class HomeViewModel {

    fun getStores(): MutableList<StoreEntity> {
        return StoreDao().getAllStores()
    }
}