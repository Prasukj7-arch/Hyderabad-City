package com.example.city.ui

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.city.R
import com.example.city.data.local.Store

@Composable
fun ListOnlyContent(
    cityUiState: CityUiState,
    storeCardPressed: (Store) -> Unit,
    modifier: Modifier = Modifier
) {
    val stores = cityUiState.currentCityStore
    LazyColumn(
        modifier = modifier,
        contentPadding = WindowInsets.safeDrawing.asPaddingValues(),
        verticalArrangement = Arrangement.spacedBy(
            dimensionResource(R.dimen.email_list_item_vertical_spacing)
        )
    ) {
        item {
            HomeTopBar(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = dimensionResource(R.dimen.topbar_padding_vertical))
            )
        }
        items(stores, key = { store -> store.id }) { store ->
            storeListItem(
                store = store,
                selected = cityUiState.currentSelected.id == store.id,
                onCardClick = {
                    storeCardPressed(store)
                },
            )
        }
    }
}

@Composable
fun ReplyListAndDetailContent(
    cityUiState: CityUiState,
    storeCardPressed: (Store) -> Unit,
    modifier: Modifier = Modifier
) {
    val stores = cityUiState.currentCityStore
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        LazyColumn(
            contentPadding = WindowInsets.statusBars.asPaddingValues(),
            modifier = Modifier
                .weight(1f)
                .padding(horizontal = dimensionResource(R.dimen.email_list_only_horizontal_padding)),
            verticalArrangement = Arrangement.spacedBy(
                dimensionResource(R.dimen.email_list_item_vertical_spacing)
            )
        ) {
            items(stores, key = { store -> store.id }) { store ->
                storeListItem(
                    store = store,
                    selected = cityUiState.currentSelected.id == store.id,
                    onCardClick = {
                        storeCardPressed(store)
                    },
                )
            }
        }
        StoreDetailScreen(
            cityUiState = cityUiState,
            modifier = Modifier
                .padding(top = dimensionResource(R.dimen.email_list_item_vertical_spacing))
                .weight(1f),
            onBackPressed = {}
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun storeListItem(
    store: Store,
    selected: Boolean,
    onCardClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier.height(85.dp),
        colors = CardDefaults.cardColors(
            containerColor = if (selected)
                MaterialTheme.colorScheme.primaryContainer
            else
                MaterialTheme.colorScheme.secondaryContainer
        ),
        onClick = onCardClick
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()

        ) {
            PlaceImageItem(
                place = store,
                modifier = Modifier.height(200.dp).width(150.dp)
            )
            Text(
                text = stringResource(store.storeResourceId),
                fontSize = 16.sp,
                color = MaterialTheme.colorScheme.onSurface,
                modifier = Modifier.align(Alignment.CenterVertically).padding(16.dp),
            )
        }
    }
}

@Composable
fun PlaceImageItem(place:Store, modifier: Modifier)
{
    Box(
        modifier = modifier
    ) {
        Image(
            painter = painterResource(place.storeImageBanner),
            contentDescription = null,
            alignment = Alignment.Center,
            contentScale = ContentScale.FillWidth
        )
    }
}

@Composable
private fun HomeTopBar(modifier: Modifier = Modifier) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
    ) {
        Logo(
            modifier = Modifier
                .width(150.dp).height(50.dp)
                .padding(start = dimensionResource(R.dimen.topbar_logo_padding_start))
        )
        ProfileImage(
            drawableResource = R.drawable.logo,
            description = stringResource(R.string.profile),
            modifier = Modifier
                .padding(end = dimensionResource(R.dimen.topbar_profile_image_padding_end))
                .size(dimensionResource(R.dimen.topbar_profile_image_size))
        )
    }
}

@Composable
fun ProfileImage(
    @DrawableRes drawableResource: Int,
    description: String,
    modifier: Modifier = Modifier,
) {
    Box(modifier = modifier) {
        Image(
            modifier = Modifier.clip(CircleShape),
            painter = painterResource(drawableResource),
            contentDescription = description,
        )
    }
}

@Composable
fun Logo(
    modifier: Modifier = Modifier,
    color: Color = MaterialTheme.colorScheme.primary
) {
    Image(
        painter = painterResource(R.drawable.whatsapp_image_2024_05_18_at_18_23_24_removebg_preview),
        contentDescription = stringResource(R.string.logo),
        modifier = modifier
    )
}
