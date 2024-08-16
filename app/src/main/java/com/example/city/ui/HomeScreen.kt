package com.example.city.ui

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.NavigationRail
import androidx.compose.material3.NavigationRailItem
import androidx.compose.material3.PermanentDrawerSheet
import androidx.compose.material3.PermanentNavigationDrawer
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import com.example.city.R
import com.example.city.data.local.StoreType
import com.example.city.ui.utils.StoreNavigationType
import com.example.city.data.local.Store
import com.example.city.ui.utils.Theaters


@Composable
fun HomeScreen(
    navigationType: StoreNavigationType,
    cityUiState: CityUiState,
    onTabPressed: (StoreType) -> Unit,
    onCardPressed: (Store) -> Unit,
    onDetailScreenBackPressed: () -> Unit,
    modifier: Modifier = Modifier
) {
    val navigationItemContentList = listOf(
        NavigationItemContent(
            storetype = StoreType.Cafe,
            icon = Icons.Default.Restaurant,
            text = stringResource(id = R.string.res)
        ),
        NavigationItemContent(
            storetype = StoreType.University,
            icon = Icons.Default.School,
            text = stringResource(id = R.string.univer)
        ),
        NavigationItemContent(
            storetype = StoreType.Movies,
            icon = Icons.Default.Theaters,
            text = stringResource(id = R.string.theater)
        ),
        NavigationItemContent(
            storetype = StoreType.Museums,
            icon = Icons.Default.Museum,
            text = stringResource(id = R.string.museums)
        ),
        NavigationItemContent(
            storetype = StoreType.Location,
            icon = Icons.Default.LocationOn,
            text = stringResource(id = R.string.loc)
        )

    )
    if (navigationType == StoreNavigationType.PERMANENT_NAVIGATION_DRAWER
        && cityUiState.isShowingHomepage
    ) {
        PermanentNavigationDrawer(
            drawerContent = {
                PermanentDrawerSheet(Modifier.width(dimensionResource(R.dimen.drawer_width))) {
                    NavigationDrawerContent(
                        selectedDestination = cityUiState.current,
                        onTabPressed = onTabPressed,
                        navigationItemContentList = navigationItemContentList,
                        modifier = Modifier
                            .wrapContentWidth()
                            .fillMaxHeight()
                            .background(MaterialTheme.colorScheme.inverseOnSurface)
                            .padding(dimensionResource(R.dimen.drawer_padding_content))
                    )
                }
            }
        ) {
            ReplyAppContent(
                navigationType = navigationType,
                cityUiState = cityUiState,
                onTabPressed = onTabPressed,
                onCardPressed = onCardPressed,
                navigationItemContentList = navigationItemContentList,
                modifier = modifier
            )
        }
    }
    else {
        if (cityUiState.isShowingHomepage) {
            ReplyAppContent(
                navigationType = navigationType,
                cityUiState = cityUiState,
                onTabPressed = onTabPressed,
                onCardPressed = onCardPressed,
                navigationItemContentList = navigationItemContentList,
                modifier = modifier

            )
        } else {
            StoreDetailScreen(
                cityUiState = cityUiState,
                onBackPressed = onDetailScreenBackPressed,
                modifier = modifier
            )
        }
    }
}

@Composable
private fun ReplyAppContent(
    navigationType: StoreNavigationType,
    cityUiState: CityUiState,
    onTabPressed: ((StoreType) -> Unit),
    onCardPressed: (Store) -> Unit,
    navigationItemContentList: List<NavigationItemContent>,
    modifier: Modifier = Modifier,
) {
    Row(modifier = modifier) {
        AnimatedVisibility(visible = navigationType == StoreNavigationType.NAVIGATION_RAIL) {
            ReplyNavigationRail(
                currentTab = cityUiState.current,
                onTabPressed = onTabPressed,
                navigationItemContentList = navigationItemContentList,
            )
        }
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.inverseOnSurface)
        ) {
            ListOnlyContent(
                cityUiState = cityUiState,
                storeCardPressed = onCardPressed,
                modifier = Modifier.weight(1f)
                    .padding(
                        horizontal = dimensionResource(R.dimen.email_list_only_horizontal_padding)
                    )
            )
            AnimatedVisibility(visible = navigationType == StoreNavigationType.BOTTOM_NAVIGATION) {
                val bottomNavigationContentDescription = stringResource(R.string.navigation_bottom)
                ReplyBottomNavigationBar(
                    currentTab = cityUiState.current,
                    onTabPressed = onTabPressed,
                    navigationItemContentList = navigationItemContentList,
                    modifier = Modifier
                        .fillMaxWidth()
                )
            }
        }
    }
}

@Composable
private fun ReplyNavigationRail(
    currentTab: StoreType,
    onTabPressed: ((StoreType) -> Unit),
    navigationItemContentList: List<NavigationItemContent>,
    modifier: Modifier = Modifier
) {
    NavigationRail(modifier = modifier) {
        for (navItem in navigationItemContentList) {
            NavigationRailItem(
                selected = currentTab == navItem.storetype,
                onClick = { onTabPressed(navItem.storetype) },
                icon = {
                    Icon(
                        imageVector = navItem.icon,
                        contentDescription = navItem.text
                    )
                }
            )
        }
    }
}

@Composable
private fun ReplyBottomNavigationBar(
    currentTab: StoreType,
    onTabPressed: ((StoreType) -> Unit),
    navigationItemContentList: List<NavigationItemContent>,
    modifier: Modifier = Modifier
) {
    NavigationBar(modifier = modifier) {
        for (navItem in navigationItemContentList) {
            NavigationBarItem(
                selected = currentTab == navItem.storetype,
                onClick = { onTabPressed(navItem.storetype) },
                icon = {
                    Icon(
                        imageVector = navItem.icon,
                        contentDescription = navItem.text
                    )
                }
            )
        }
    }
}

@Composable
private fun NavigationDrawerContent(
    selectedDestination: StoreType,
    onTabPressed: ((StoreType) -> Unit),
    navigationItemContentList: List<NavigationItemContent>,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        for (navItem in navigationItemContentList) {
            NavigationDrawerItem(
                selected = selectedDestination == navItem.storetype,
                label = {
                    Text(
                        text = navItem.text,
                        modifier = Modifier.padding(horizontal = dimensionResource(R.dimen.drawer_padding_header))
                    )
                },
                icon = {
                    Icon(
                        imageVector = navItem.icon,
                        contentDescription = navItem.text
                    )
                },
                colors = NavigationDrawerItemDefaults.colors(
                    unselectedContainerColor = Color.Transparent
                ),
                onClick = { onTabPressed(navItem.storetype) }
            )
        }
    }
}


private data class NavigationItemContent(
    val storetype: StoreType,
    val icon: ImageVector,
    val text: String
)