package com.jeromedusanter.exomindtest.ui.features.city

import com.jeromedusanter.base_android.ui.base.IUiModel

data class CityUiModel(
    val name: String,
    val temperature: String,
    val cloudiness: String
) : IUiModel