package com.jeromedusanter.exomindtest.di

import com.jeromedusanter.exomindtest.data.CityRepositoryImpl
import com.jeromedusanter.exomindtest.domain.boundaries.CityRepository
import dagger.Binds
import dagger.Module

@Module
abstract class RepositoryModule {

    @Binds
    internal abstract fun bindsRepository(instance: CityRepositoryImpl): CityRepository
}