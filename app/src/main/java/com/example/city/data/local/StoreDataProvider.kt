package com.example.city.data.local

import com.example.city.R

object StoreDataProvider {
    val allstores = listOf(
        Store(
            id = 0L,
            storeResourceId = R.string.cafe1,
            storeImageBanner = R.drawable.bidri_ambience,
            storedetails = R.string.cafe1d
        ),
        Store(
            id = 1L,
            storeResourceId = R.string.cafe2,
            storeImageBanner = R.drawable._023_06_15,
            storedetails = R.string.cafe2d
        ),
        Store(
            id = 2L,
            storeResourceId = R.string.cafe3,
            storeImageBanner = R.drawable.img_20180923_011029_879,
            storedetails = R.string.cafe3d
        ),
        Store(
            id = 3L,
            storeResourceId = R.string.cafe4,
            storeImageBanner = R.drawable.ambiance,
            storedetails = R.string.cafe4d
        ),
        Store(
            id = 4L,
            storeResourceId = R.string.cafe5,
            storeImageBanner = R.drawable.ambiance__1_,
            storedetails = R.string.cafe5d
        ),
        Store(
            id = 5L,
            storeResourceId = R.string.mov1,
            storeImageBanner = R.drawable._021_11_13,
            storedetails = R.string.mov1d,
            storebox = StoreType.Movies
        ),
        Store(
            id = 6L,
            storeResourceId = R.string.mov2,
            storeImageBanner = R.drawable.forum_sujana_hyderabad,
            storedetails = R.string.mov2d,
            storebox = StoreType.Movies
        ),
        Store(
            id = 7L,
            storeResourceId = R.string.mov3,
            storeImageBanner = R.drawable.gvk_one_mall_banjara_hills_hyderabad_malls_h8ztku3s3h,
            storedetails = R.string.mov3d,
            storebox = StoreType.Movies
        ),
        Store(
            id = 8L,
            storeResourceId = R.string.mov4,
            storeImageBanner = R.drawable._023_01_10,
            storedetails = R.string.mov4d,
            storebox = StoreType.Movies
        ),
        Store(
            id = 9L,
            storeResourceId = R.string.mov5,
            storeImageBanner = R.drawable._847351611886806233043697088n_20210128174357,
            storedetails = R.string.mov5d,
            storebox = StoreType.Movies
        ),
        Store(
            id = 10L,
            storeResourceId = R.string.loc1,
            storeImageBanner = R.drawable.m_activities_hyderabad_charminar_l_514_776,
            storedetails = R.string.loc1d,
            storebox = StoreType.Location
        ),
        Store(
            id = 11L,
            storeResourceId = R.string.loc2,
            storeImageBanner = R.drawable.m_golconda_fort_1_l_428_640,
            storedetails = R.string.loc2d,
            storebox = StoreType.Location
        ),
        Store(
            id = 12L,
            storeResourceId = R.string.loc3,
            storeImageBanner = R.drawable.m_nehru_zoological_park_1_l_381_572,
            storedetails = R.string.loc3d,
            storebox = StoreType.Location
        ),
        Store(
            id = 13L,
            storeResourceId = R.string.loc4,
            storeImageBanner = R.drawable.m_activities_hyderabad_hussain_sagar_lake_l_486_729,
            storedetails = R.string.loc4d,
            storebox = StoreType.Location
        ),
        Store(
            id = 14L,
            storeResourceId = R.string.loc5,
            storeImageBanner = R.drawable.chowmahalla_palace_01,
            storedetails = R.string.loc5d,
            storebox = StoreType.Location
        ),
        Store(
            id = 15L,
            storeResourceId = R.string.uni1,
            storeImageBanner = R.drawable._022_08_26,
            storedetails = R.string.uni1d,
            storebox = StoreType.University
        ),
        Store(
            id = 16L,
            storeResourceId = R.string.uni2,
            storeImageBanner = R.drawable._021_10_26,
            storedetails = R.string.uni2d,
            storebox = StoreType.University
        ),
        Store(
            id = 17L,
            storeResourceId = R.string.uni3,
            storeImageBanner = R.drawable._022_07_18,
            storedetails = R.string.uni3d,
            storebox = StoreType.University
        ),
        Store(
            id = 18L,
            storeResourceId = R.string.uni4,
            storeImageBanner = R.drawable._489735638phpuhvqgz,
            storedetails = R.string.uni4d,
            storebox = StoreType.University
        ),
        Store(
            id = 19L,
            storeResourceId = R.string.uni5,
            storeImageBanner = R.drawable.ifhe_campus,
            storedetails = R.string.uni5d,
            storebox = StoreType.University
        ),
        Store(
            id = 20L,
            storeResourceId = R.string.mus1,
            storeImageBanner = R.drawable.whatsapp_image_2024_05_18_at_18_21_07,
            storedetails = R.string.uni1d,
            storebox = StoreType.Museums
        ),
        Store(
            id = 21L,
            storeResourceId = R.string.mus2,
            storeImageBanner = R.drawable.chowmahalla_palace_01,
            storedetails = R.string.uni2d,
            storebox = StoreType.Museums
        ),
        Store(
            id = 22L,
            storeResourceId = R.string.mus3,
            storeImageBanner = R.drawable._022_09_09,
            storedetails = R.string.uni3d,
            storebox = StoreType.Museums
        ),
        Store(
            id = 23L,
            storeResourceId = R.string.mus4,
            storeImageBanner = R.drawable._022_12_05,
            storedetails = R.string.uni4d,
            storebox = StoreType.Museums
        ),
        Store(
            id = 24L,
            storeResourceId = R.string.mus5,
            storeImageBanner = R.drawable.pxl_20221215_100659027,
            storedetails = R.string.uni5d,
            storebox = StoreType.Museums
        ),
    )
    fun get(id: Long): Store? {
        return allstores.firstOrNull { it.id == id }
    }
    val defaultstore = Store(
        id = -1,
    )
}