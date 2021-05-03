package com.jeromedusanter.exomindtest.ui.features.city.list

import com.jeromedusanter.base_android.ui.base.IUiModel
import com.jeromedusanter.exomindtest.ui.features.city.CityUiModel

data class CityListUiModel(
    val list: List<CityUiModel>,
    val progressLoading: Int,
    val titleLoading : Int
) : IUiModel