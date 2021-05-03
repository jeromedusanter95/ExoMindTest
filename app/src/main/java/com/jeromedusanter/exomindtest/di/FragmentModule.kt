package com.jeromedusanter.exomindtest.di

import com.jeromedusanter.exomindtest.ui.features.city.list.CityListFragment
import com.jeromedusanter.exomindtest.ui.features.splash.SplashFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentModule {

    @ContributesAndroidInjector
    abstract fun contributeSplashFragment(): SplashFragment

    @ContributesAndroidInjector
    abstract fun contributeCityListFragment(): CityListFragment

}