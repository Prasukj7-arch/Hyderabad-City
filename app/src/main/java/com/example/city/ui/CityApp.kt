package com.example.city.ui

import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.city.data.local.Store
import com.example.city.data.local.StoreType
import com.example.city.ui.utils.StoreNavigationType

@Composable
fun CityApp(
    windowSize: WindowWidthSizeClass,
    modifier: Modifier = Modifier,
) {
    val viewModel: StoreViewModal = viewModel()
    val cityUiState = viewModel.uiState.collectAsState().value
    val navigationType: StoreNavigationType
    when (windowSize) {
        WindowWidthSizeClass.Compact -> {
            navigationType = StoreNavigationType.BOTTOM_NAVIGATION
        }
        WindowWidthSizeClass.Medium -> {
            navigationType = StoreNavigationType.NAVIGATION_RAIL
        }
        WindowWidthSizeClass.Expanded -> {
            navigationType = StoreNavigationType.PERMANENT_NAVIGATION_DRAWER
        }
        else -> {
            navigationType = StoreNavigationType.BOTTOM_NAVIGATION
        }
    }
    HomeScreen(
        navigationType = navigationType,
        cityUiState = cityUiState,
        onTabPressed = { storetype: StoreType ->
            viewModel.updateCurrentMailbox(storetype = storetype)
            viewModel.resetHomeScreenStates()
        },
        onCardPressed = { store: Store ->
            viewModel.updateDetailsScreenStates(
                store = store
            )
        },
        onDetailScreenBackPressed = {
            viewModel.resetHomeScreenStates()
        },
        modifier = modifier
    )
}

