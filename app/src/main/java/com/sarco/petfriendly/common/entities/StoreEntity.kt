package com.sarco.petfriendly.common.entities

data class StoreEntity(val id: Long,
                       val name: String,
                       val description: String,
                       val address: String,
                       val country: String,
                       var image: String = "",
                       val author: String
                       )