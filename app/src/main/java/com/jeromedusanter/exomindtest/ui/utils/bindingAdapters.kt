package com.jeromedusanter.exomindtest.ui.utils

import android.widget.TextView
import androidx.annotation.StringRes
import androidx.databinding.BindingAdapter
import com.jeromedusanter.exomindtest.R

@BindingAdapter("app:textRes")
fun setTextRes(view: TextView, @StringRes resId: Int) {
    if (resId != -1) view.setText(resId)
}

@BindingAdapter("app:cityListLoadingTitle")
fun setCityListLoadingTitle(view: TextView, count: Int) {
    when (count) {
        1 -> view.setText(R.string.city_list_loading_title_1)
        2 -> view.setText(R.string.city_list_loading_title_2)
        3 -> view.setText(R.string.city_list_loading_title_3)
    }
}
