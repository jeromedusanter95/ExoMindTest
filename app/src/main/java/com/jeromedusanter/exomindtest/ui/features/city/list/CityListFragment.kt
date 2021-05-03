package com.jeromedusanter.exomindtest.ui.features.city.list

import android.animation.ObjectAnimator
import android.view.animation.AlphaAnimation
import android.view.animation.Animation
import android.view.animation.DecelerateInterpolator
import android.widget.ProgressBar
import androidx.fragment.app.viewModels
import com.jeromedusanter.exomindtest.R
import com.jeromedusanter.exomindtest.databinding.FragmentCityListBinding
import com.jeromedusanter.exomindtest.ui.base.ExomindFragment
import com.jeromedusanter.exomindtest.ui.features.city.CityAction
import com.jeromedusanter.exomindtest.ui.features.city.CityViewModel


class CityListFragment : ExomindFragment<FragmentCityListBinding, CityAction, CityViewModel>() {

    override val resId: Int = R.layout.fragment_city_list

    override val viewModel: CityViewModel by viewModels { factory }

    private val adapter by lazy { CityListAdapter() }

    override fun initView() {
        setHasOptionsMenu(true)
        with(binding) {
            statefulLayoutCityList.setLoadingView(this@CityListFragment.viewModel) {

                val anim: Animation = AlphaAnimation(0.0f, 1.0f)
                    .apply {
                        duration = 1000
                        startOffset = 20
                        repeatMode = Animation.REVERSE
                        repeatCount = Animation.INFINITE
                    }
                this.textTitle.animation = anim
            }
            recyclerCity.adapter = adapter
            buttonRetry.setOnClickListener { this@CityListFragment.viewModel.refreshPage() }
        }
    }
}