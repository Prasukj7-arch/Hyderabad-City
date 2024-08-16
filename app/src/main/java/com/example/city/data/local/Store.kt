package com.example.city.data.local

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Store(
    val id: Long,
    @StringRes val storeResourceId: Int = -1,
    @DrawableRes val storeImageBanner: Int = -1,
    @StringRes val storedetails: Int = -1,
    var storebox: StoreType = StoreType.Cafe,
)