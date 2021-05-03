package com.jeromedusanter.exomindtest.ui.main

import androidx.activity.viewModels
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupActionBarWithNavController
import com.jeromedusanter.exomindtest.R
import com.jeromedusanter.exomindtest.databinding.ActivityMainBinding
import com.jeromedusanter.exomindtest.ui.base.ExomindActivity

class MainActivity : ExomindActivity<ActivityMainBinding, MainAction, MainViewModel>() {

    private val navController by lazy { findNavController(R.id.nav_host_fragment) }

    private val appBarConfiguration by lazy { AppBarConfiguration(setOf(R.id.fragment_splash)) }

    override val resId: Int = R.layout.activity_main

    override val viewModel: MainViewModel by viewModels { factory }

    override fun onStart() {
        super.onStart()
        setupActionBarWithNavController(navController, appBarConfiguration)
    }

    override fun onSupportNavigateUp() = NavigationUI.navigateUp(navController, appBarConfiguration)
}