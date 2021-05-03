package com.jeromedusanter.exomindtest.di

import com.jeromedusanter.exomindtest.Application
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ApplicationModule constructor(private val application: Application) {

    @Provides
    @Singleton
    internal fun provideContext() = application.applicationContext
}