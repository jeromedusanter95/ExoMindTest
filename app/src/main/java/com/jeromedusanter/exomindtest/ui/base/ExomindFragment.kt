package com.jeromedusanter.exomindtest.ui.base

import android.content.Context
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModelProvider
import com.jeromedusanter.base_android.ui.base.BaseFragment
import com.jeromedusanter.base_android.ui.base.BaseViewModel
import com.jeromedusanter.base_android.ui.base.IAction
import com.jeromedusanter.exomindtest.BR
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

abstract class ExomindFragment<B : ViewDataBinding, A : IAction, VM : BaseViewModel<A>> :
    BaseFragment<B, A, VM>() {

    override val viewModelVariableId: Int = BR.viewModel

    @Inject
    lateinit var factory: ViewModelProvider.Factory

    override fun onAttach(context: Context) {
        super.onAttach(context)
        AndroidSupportInjection.inject(this)
    }
}