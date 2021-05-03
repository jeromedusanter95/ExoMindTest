package com.jeromedusanter.exomindtest.ui.base

import androidx.databinding.ViewDataBinding
import com.jeromedusanter.base_android.ui.base.BaseAdapter
import com.jeromedusanter.base_android.ui.base.BaseItemViewModel
import com.jeromedusanter.base_android.ui.base.IUiModel
import com.jeromedusanter.exomindtest.BR

abstract class ExomindAdapter<B : ViewDataBinding, O : IUiModel, VM : BaseItemViewModel<O>> :
    BaseAdapter<B, O, VM>() {

    override val viewModelVariableId = BR.viewModel
}