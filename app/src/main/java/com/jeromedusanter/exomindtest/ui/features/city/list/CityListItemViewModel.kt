package com.jeromedusanter.exomindtest.ui.features.city.list

import androidx.databinding.ObservableField
import com.jeromedusanter.base_android.ui.base.BaseItemViewModel
import com.jeromedusanter.exomindtest.ui.features.city.CityUiModel

class CityListItemViewModel : BaseItemViewModel<CityUiModel>() {

    val name = ObservableField<String>()
    val temperature = ObservableField<String>()
    val cloudiness = ObservableField<String>()

    override fun onItemChanged(item: CityUiModel) {
        name.set(item.name)
        temperature.set(item.temperature)
        cloudiness.set(item.cloudiness)
    }

    override val onItemClick: ((CityUiModel, Int) -> Unit)? = null
}