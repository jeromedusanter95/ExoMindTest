package com.jeromedusanter.exomindtest.ui.features.city.list

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.databinding.DataBindingUtil
import com.jeromedusanter.exomindtest.BR
import com.jeromedusanter.exomindtest.R
import com.jeromedusanter.exomindtest.databinding.SflCityListErrorBinding
import com.jeromedusanter.exomindtest.databinding.SflCityListLoadingBinding
import com.jeromedusanter.exomindtest.ui.features.city.CityViewModel
import cz.kinst.jakub.view.StatefulLayout

class CityListStatefulLayout @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : StatefulLayout(context, attrs, defStyleAttr) {

    init {
        setStateView(
            State.EMPTY.value,
            LayoutInflater.from(getContext()).inflate(
                R.layout.sfl_default_placeholder_empty,
                null
            )
        )

        setStateView(
            State.ERROR.value,
            LayoutInflater.from(getContext()).inflate(
                R.layout.sfl_default_placeholder_offline,
                null
            )
        )
    }

    fun setLoadingView(
        viewModel: CityViewModel,
        setup: SflCityListLoadingBinding.() -> Unit
    ) {
        val binding = DataBindingUtil.inflate<SflCityListLoadingBinding>(
            LayoutInflater.from(context),
            R.layout.sfl_city_list_loading,
            this,
            false
        )
        binding.setVariable(BR.viewModel, viewModel)
        setStateView(State.LOADING.value, binding.root)
        setup.invoke(binding)
    }

    enum class State constructor(val value: String) {
        CONTENT(StatefulLayout.State.CONTENT),
        ERROR("error"),
        LOADING("loading"),
        EMPTY("empty")
    }
}