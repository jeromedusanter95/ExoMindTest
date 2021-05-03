package com.jeromedusanter.exomindtest.ui.features.splash

import androidx.fragment.app.viewModels
import com.jeromedusanter.exomindtest.R
import com.jeromedusanter.exomindtest.databinding.FragmentSplashBinding
import com.jeromedusanter.exomindtest.ui.base.ExomindFragment

class SplashFragment : ExomindFragment<FragmentSplashBinding, SplashAction, SplashViewModel>() {

    override val resId: Int = R.layout.fragment_splash

    override val viewModel: SplashViewModel by viewModels { factory }

    override fun initView() {
        super.initView()
        binding.buttonNext.setOnClickListener {
            navigate(SplashFragmentDirections.actionNavigateToCityList())
        }
    }
}