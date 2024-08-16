package com.example.city.ui

import androidx.lifecycle.ViewModel
import com.example.city.data.local.Store
import com.example.city.data.local.StoreDataProvider
import com.example.city.data.local.StoreType
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

class StoreViewModal : ViewModel(){
    private val _uiState = MutableStateFlow(CityUiState())
    val uiState: StateFlow<CityUiState> = _uiState
    init {
        initializeUIState()
    }
    private fun initializeUIState() {
        val cityboxes: Map<StoreType, List<Store>> =
            StoreDataProvider.allstores.groupBy { it.storebox }
        _uiState.value =
            CityUiState(
                storeboxes = cityboxes,
                currentSelected = cityboxes[StoreType.Cafe]?.get(0)
                    ?: StoreDataProvider.defaultstore
            )
    }

    fun updateDetailsScreenStates(store: Store) {
        _uiState.update {
            it.copy(
                currentSelected = store,
                isShowingHomepage = false
            )
        }
    }

    fun resetHomeScreenStates() {
        _uiState.update {
            it.copy(
                currentSelected = it.storeboxes[it.current]?.get(0)
                    ?: StoreDataProvider.defaultstore,
                isShowingHomepage = true
            )
        }
    }

    fun updateCurrentMailbox(storetype: StoreType) {
        _uiState.update {
            it.copy(
                current = storetype
            )
        }
    }
}