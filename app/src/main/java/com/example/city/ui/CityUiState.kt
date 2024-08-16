package com.example.city.ui

import com.example.city.data.local.Store
import com.example.city.data.local.StoreDataProvider
import com.example.city.data.local.StoreType

data class CityUiState (
    val storeboxes: Map<StoreType, List<Store>> = emptyMap(),
    val current: StoreType = StoreType.Cafe,
    val currentSelected: Store = StoreDataProvider.defaultstore,
    val isShowingHomepage: Boolean = true
) {
    val currentCityStore: List<Store> by lazy { storeboxes[current]!! }
}