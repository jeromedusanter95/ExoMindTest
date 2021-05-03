package com.jeromedusanter.exomindtest.ui.features.city.list

import com.jeromedusanter.exomindtest.R
import com.jeromedusanter.exomindtest.databinding.ItemCityBinding
import com.jeromedusanter.exomindtest.ui.base.ExomindAdapter
import com.jeromedusanter.exomindtest.ui.features.city.CityUiModel


class CityListAdapter : ExomindAdapter<ItemCityBinding, CityUiModel, CityListItemViewModel>() {

    override val resId: Int = R.layout.item_city

    override fun createViewModel() = CityListItemViewModel()
}